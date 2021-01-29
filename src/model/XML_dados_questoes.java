package model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class XML_dados_questoes {
	
	private static ArrayList<Questao> questoes = new ArrayList<>();

	public static ArrayList<Questao> getPerguntas() {
		return questoes;
	}
	
	public static void SalvarDados() {
		
			try {
				XStream xStream = new XStream(new DomDriver());
				File file = new File("res/questoesBD.xml");
				if(!file.exists()) {
					file.createNewFile();
				}else {
					file.delete();
					file.createNewFile();
				}
				PrintWriter write = new PrintWriter(file);
				write.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
				String dados = xStream.toXML(questoes);
				write.println(dados);
				write.flush();
				write.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
	}
	
	public static void LerDados() {
		XStream xStream = new XStream(new DomDriver());
		File file = new File("res/questoesBD.xml");
		
		if(file.exists()) {
			questoes = (ArrayList<Questao>) xStream.fromXML(file);
			
		}else {
			questoes = new ArrayList<>();
			
		}
		
	}
	
	
	
	
//	public  void geraArquivo(Questao qst) throws IOException {
//		XStream xStream = new XStream(new DomDriver());
//		xStream.alias("Questionario", Questao.class);
//
//		DataOutputStream out = new DataOutputStream(
//				new BufferedOutputStream(new FileOutputStream("res/questoesBD.xml")));
//
//		out.writeBytes(xStream.toXML(qst));
//		out.flush();
//		out.close();
//	}
//
//	public Object[] carregarDados() throws FileNotFoundException, IOException{
//		List<String> linhas = new ArrayList<String>();
//
//		InputStream file = getClass().getResourceAsStream("/questoesBD.xml");
//		BufferedReader bufferFile = new BufferedReader(new InputStreamReader(file));
//
//		String linhaLida = bufferFile.readLine();
//
//		while(linhaLida != null){
//			linhas.add(linhaLida);
//			linhaLida = bufferFile.readLine();
//
//		}
//
//		bufferFile.close();
//		return linhas.toArray();
//	}

}
