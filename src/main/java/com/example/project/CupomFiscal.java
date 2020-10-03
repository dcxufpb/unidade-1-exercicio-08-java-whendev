package com.example.project;

public class CupomFiscal {
	public static Boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}

	public static String dadosLojaObjeto(Loja loja) {
		if (isNullOrEmpty(loja.getNomeLoja())){
			throw new RuntimeException("O campo nome da loja é obrigatório");
		}

		if (isNullOrEmpty(loja.getLogradouro())){
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}

		if (isNullOrEmpty(loja.getMunicipio())){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}

		if (isNullOrEmpty(loja.getEstado())){
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		}

		if (isNullOrEmpty(loja.getCnpj())){
			throw new RuntimeException("O campo cnpj da loja é obrigatório");
		}

		if (isNullOrEmpty(loja.getInscricaoEstadual())) {
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}

		String _COMPLEMENTO = "";
		if (!isNullOrEmpty(loja.getComplemento())){
			_COMPLEMENTO = " " + loja.getComplemento();
		}

		String _BAIRRO = "";
		if (!isNullOrEmpty(loja.getBairro())) {
			_BAIRRO = loja.getBairro() + " - ";
		}

		String _CEP = "";
		String _TELEFONE = "";

		if (!isNullOrEmpty(loja.getCep())) {
			_CEP = "CEP:" + loja.getCep();
			if (!isNullOrEmpty(loja.getTelefone())){
				_TELEFONE = " Tel " + loja.getTelefone();
			}
		} else {
			_CEP = "";
			if (!isNullOrEmpty(loja.getTelefone())){
				_TELEFONE = "Tel " + loja.getTelefone();
			}
		}

		String _OBSERVACAO = "";
		if (!isNullOrEmpty(loja.getObservacao())){
			_OBSERVACAO = loja.getObservacao();
		}

		String _texto = "";
		_texto = String.format("%s\r\n",loja.getNomeLoja());
		if (loja.getNumero() == 0){
			_texto += String.format("%s, %s%s\r\n",loja.getLogradouro(),"s/n",_COMPLEMENTO);
		} else {
			_texto += String.format("%s, %d%s\r\n",loja.getLogradouro(),loja.getNumero(),_COMPLEMENTO);
		}
		_texto += String.format("%s%s - %s\r\n",_BAIRRO,loja.getMunicipio(),loja.getEstado());
		_texto += String.format("%s%s\r\n",_CEP,_TELEFONE);
		_texto += String.format("%s\r\n",_OBSERVACAO);
		_texto += String.format("CNPJ: %s\r\n",loja.getCnpj());
		_texto += String.format("IE: %s\r\n",loja.getInscricaoEstadual());
		return _texto;
	}
}
