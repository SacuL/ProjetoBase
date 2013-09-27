package sonda.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraDados {

	private List<Integer> dados;

	public LeituraDados() {
		this.dados = new ArrayList<Integer>();
	}

	public List<Integer> getDados(int sensor) {

		String arquivo = "leitura.csv";
		BufferedReader br = null;
		String linha = "";

		try {

			br = new BufferedReader(new FileReader(arquivo));
			while ((linha = br.readLine()) != null) {

				String[] entradas = linha.split(";");

				// System.out.println("Lendo a posicao " + sensor);

				try {
					dados.add(Integer.parseInt(entradas[sensor]));
				} catch (ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return dados;
	}

}
