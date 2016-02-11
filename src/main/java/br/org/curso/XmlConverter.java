package br.org.curso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlConverter {

	public static void main(String[] args) throws FileNotFoundException {
		XStream stream = new XStream(new DomDriver());
		stream.setMode(XStream.NO_REFERENCES);
		stream.processAnnotations(Pessoa.class);
		
		BufferedReader file = new BufferedReader(new FileReader("src/main/java/br/org/curso/pessoas.xml"));
		
		Pessoa pessoa = (Pessoa) stream.fromXML(file);
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getIdade());
		System.out.println(pessoa.getTelefone());
	}
}
