import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Inter {

	static ArrayList<Var> var = new ArrayList<Var>();
	public static void input(String fileName) throws IOException{
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		String line;
		while((line = bf.readLine()) != null){
			
			StringTokenizer part = new StringTokenizer(line," ");

			String token = part.nextToken();
			if(token.equals ("let")){

				//if(line.startsWith("LET")){
				while(part.hasMoreElements()){
					String name;
					int value;
					name = part.nextToken();
					if(part.nextToken().equals("=")){
						value = Integer.parseInt(part.nextToken());
						var.add(new Var(name,value));
					}
				}
			}
			else if(token.equals("print")){
				boolean check = false;
				token = part.nextToken();
				for(int i = 0;i<var.size();i++){
					if(token.equals(var.get(i).name)){
						System.out.print(var.get(i).value+ "\n");
						check = true;
						break;

					}

				}


				if(check == false){

					System.out.println(token+ " Variable not present");

				}

			}


			else{
				int i;

				boolean check1 = false;
				boolean check2 = false;
				boolean check3 = false;
				for( i = 0;i<var.size();i++){
					if(token.equals(var.get(i).name)){
						check1 = true;
						break;
					}
				}
				if(check1 == false){

					System.out.println(token +" Variable not declared");

				}

				if(part.nextToken().equals("=")){
					int j;
					token = part.nextToken();
					for( j = 0;j<var.size();j++){
						if(token.equals(var.get(j).name)){
							check2 = true;						
							break;

						}
					}

					if(check2 == false){

						System.out.println(token +" Variable not declared");

					}
					String token1;
					token1 = part.nextToken();


					token = part.nextToken();
					int k;
					for( k = 0;k<var.size();k++){
						if(token.equals(var.get(k).name)){
							check1 = true;
							break;
						}
					}
					if(check1 == false){

						System.out.println(token +" Variable not declared");

					}


					switch(token1){
					case "+":
						var.get(i).value = var.get(j).value + var.get(k).value;
					case "-":
						var.get(i).value = var.get(j).value - var.get(k).value;
					case "*":
						var.get(i).value = var.get(j).value * var.get(k).value;
					case "/":
						var.get(i).value /= var.get(j).value;


					}





				}

			}
		}
	}
}