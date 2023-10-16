


import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class banco{

    public static void main(String[] args) throws IOException, InterruptedException {
        System.load("C:\\Users\\ALMG\\IdeaProjects\\Java_Databaswe\\mssql-jdbc_auth-12.4.0.x64.dll");
        ArrayList <Servidor> servidores = new ArrayList<Servidor>();

//				
        Banco_menu menu = new Banco_menu ();
        String serverName = "localhost";
        int portNumber = 1433;
        String databaseName = "GAC";
        String username = "DELL3420/ALMG";
        String password = "";

        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + databaseName + ";password=" + password+ ";encrypt="+true + ";integratedSecurity="+true + ";trustServerCertificate="+true;




        try (Scanner leia = new Scanner (System.in)) {
            BufferedReader leiaa = new BufferedReader(new InputStreamReader(System.in));
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM Servidores ORDER BY id_matricula;";


            // Criação do objeto Statement
            Statement statement = connection.createStatement();

            // Execução da consulta e obtenção dos resultados
            ResultSet resultSet = statement.executeQuery(query);

            // Geração do relatório
//			            System.out.println("TABELA SERVIDORES:");
//			            System.out.println("-----------------------------------------------------------------------------------------------------------");
//			            System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", "ID", "NOME", "CPF", "UF", "SALARIO", "SETOR", "CARGO");
//			            System.out.println("-----------------------------------------------------------------------------------------------------------");
//			            
            while (resultSet.next()) {
                Servidor novoServidor = new Servidor();

                int id_matricula = resultSet.getInt("id_matricula");
                novoServidor.setId_matricula(id_matricula);


                String nom_servidor = resultSet.getString("nom_servidor");
                novoServidor.setNom_servidor(nom_servidor);

                String cpf_servidor = resultSet.getString("cpf_servidor");
                novoServidor.setCpf_servidor(cpf_servidor);

                String sigla_uf = resultSet.getString("sigla_uf");
                novoServidor.setSigla_uf(sigla_uf);

                double val_salario = resultSet.getDouble("val_salario");
                novoServidor.setVal_salario(val_salario);

                String id_sigla = resultSet.getString("id_sigla");
                novoServidor.setId_sigla(id_sigla);

                String cargo = resultSet.getString("cargo");
                novoServidor.setCargo(cargo);

                servidores.add(novoServidor);

//			                System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", id_matricula, nom_servidor, cpf_servidor, sigla_uf, val_salario , id_sigla,cargo);




            }



            String op1;
            do {
                limpa();


                menu.menu_inicial();
                op1 = leia.next().toUpperCase();




                switch(op1) {

                    case "A":
                        String op2;


                        do {
                            limpa();

                            menu.menu_loc();
                            op2 = leia.next();


                            if(op2.equalsIgnoreCase("A")) {
                                limpa();
                                int matriculaS;
                                boolean encontrei =false;
                                System.out.println("\nDIGITE A MATRICULA DO SERVIDOR QUE DESEJA PROCURAR");

                                while(!leia.hasNextInt()) {
                                    limpa();
                                    System.out.println("ENTRADA INVÁLIDA!");
                                    System.out.println("DIGITE A MATRICULA DO SERVIDOR QUE DESEJA PROCURAR");
                                    Thread.sleep(1 * 1000);

                                    leia.next();

                                }
                                matriculaS = leia.nextInt();


                                for(Servidor servidor: servidores) {

                                    if(servidor.getId_matricula() == matriculaS) {
                                        String op222;
                                        do {

                                            limpa();
                                            encontrei = true;
                                            System.out.println("SERVIDOR\n"
                                                    + "=====================================\n"
                                                    + "NOME: " + servidor.getNom_servidor().toUpperCase()+"\n"
                                                    + "MATRICULA: " +servidor.getId_matricula()	 + "\n"
                                                    + "CPF: " + servidor.getCpf_servidor() +"\n"
                                                    + "UF: " + servidor.getSigla_uf() + "\n"
                                                    + "SALARIO: " +servidor.getVal_salario() + "\n"
                                                    + "SETOR: " +servidor.getId_sigla() + "\n"
                                                    + "CARGO: " +servidor.getCargo()  + "\n"
                                                    + "=====================================");
                                            System.out.println("DIGITE (0) PARA VOLTAR");
                                            op222 = leia.next();

                                            if(!op222.equalsIgnoreCase("0")) {
                                                System.out.println("ENTRADA INVÁLIDA");
                                                Thread.sleep(1 * 1000);

                                            }


                                        }while(!op222.equalsIgnoreCase("0"));


                                    }




                                }
                                if(!encontrei) {
                                    limpa();
                                    System.out.println("MATRICULA NÃO ENCONTRADA\n");
                                    Thread.sleep(2 * 1000);

                                }
                            }




                            if(op2.equalsIgnoreCase("B")) {
                                String nome;
                                boolean encontrei1 = false;
                                do {

                                    limpa();
                                    System.out.println("DIGITE O NOME DO SERVIDOR QUE DESEJA PROCURAR");
                                    nome = leiaa.readLine();
                                    if (!nome.matches("^[\\p{L} ]+$")) {
                                        System.out.println("ENTRADA INVÁLIDA");
                                        Thread.sleep(1 * 1000);
                                    }
                                } while (!nome.matches("^[\\p{L} ]+$"));



                                nome = nome.toUpperCase();



                                for(Servidor servidor: servidores) {
                                    if(servidor.getNom_servidor().equalsIgnoreCase(nome)) {
                                        String op2222;
                                        do {



                                            encontrei1 = true;
                                            limpa();
                                            System.out.println("\nSERVIDOR\n"
                                                    + "=====================================\n"
                                                    + "NOME: " + servidor.getNom_servidor().toUpperCase()+"\n"
                                                    + "MATRICULA: " +servidor.getId_matricula()	 + "\n"
                                                    + "CPF: " + servidor.getCpf_servidor() +"\n"
                                                    + "UF: " + servidor.getSigla_uf() + "\n"
                                                    + "SALARIO: " +servidor.getVal_salario() + "\n"
                                                    + "SETOR: " +servidor.getId_sigla() + "\n"
                                                    + "CARGO: " +servidor.getCargo()  + "\n"
                                                    + "=====================================\n");
                                            System.out.println("DIGITE (0) PARA VOLTAR");
                                            op2222 = leia.next();

                                            if(!op2222.equalsIgnoreCase("0")){
                                                System.out.println("ENTRADA INVÁLIDA");
                                                Thread.sleep(1 * 1000);
                                            }

                                        }while(!op2222.equalsIgnoreCase("0"));
                                    }


                                }
                                if(!encontrei1) {
                                    limpa();
                                    System.out.println("NOME NÃO ENCONTRADO\n");
                                    Thread.sleep(2 * 1000);
                                }
                            }





                            if(op2.equalsIgnoreCase("C")) {
                                String cpf2;
                                boolean encontrei2 = false;
                                do {
                                    limpa();
                                    System.out.println("\nDIGITE O CPF DO SERVIDOR QUE DESEJA PROCURAR");
                                    cpf2 = leiaa.readLine().toUpperCase();

                                    if (!cpf2.matches("\\d{11}")) {
                                        System.out.println("\nCPF INVÁLIDO!");
                                        System.out.println("DIGITE NOVAMENTE O CPF CORRETAMENTE, NECESSITA TER 11 NUMEROS!");
                                        Thread.sleep(2 * 1000);
                                    }
                                } while (!cpf2.matches("\\d{11}"));




                                for(Servidor servidor: servidores) {
                                    if(servidor.getCpf_servidor().equalsIgnoreCase(cpf2)) {
                                        encontrei2 = true;

                                        String op22222;

                                        do {

                                            limpa();

                                            System.out.println("\nSERVIDOR\n"
                                                    + "=====================================\n"
                                                    + "NOME: " + servidor.getNom_servidor().toUpperCase()+"\n"
                                                    + "MATRICULA: " +servidor.getId_matricula()	 + "\n"
                                                    + "CPF: " + servidor.getCpf_servidor() +"\n"
                                                    + "UF: " + servidor.getSigla_uf() + "\n"
                                                    + "SALARIO: " +servidor.getVal_salario() + "\n"
                                                    + "SETOR: " +servidor.getId_sigla() + "\n"
                                                    + "CARGO: " +servidor.getCargo()  + "\n"
                                                    + "=====================================\n");
                                            System.out.println("DIGITE (0) PARA VOLTAR");
                                            op22222 = leia.next();

                                            if(!op22222.equalsIgnoreCase("0")) {
                                                System.out.println("ENTRADA INVÁLIDA");
                                                Thread.sleep(1 * 1000);

                                            }

                                        }while(!op22222.equalsIgnoreCase("0"));


                                    }


                                }
                                if(!encontrei2) {
                                    limpa();
                                    System.out.println("\nCPF NÃO ENCONTRADO\n");
                                    Thread.sleep(2 * 1000);
                                }
                            }


                            if(!op2.equalsIgnoreCase("A") && !op2.equalsIgnoreCase("B") &&!op2.equalsIgnoreCase("C") && !op2.equalsIgnoreCase("0")){

                                System.out.println("\nENTRADA INVÁLIDA");
                                Thread.sleep(2 * 1000);


                            }


                        }while(!op2.equalsIgnoreCase("A") && !op2.equalsIgnoreCase("B") &&!op2.equalsIgnoreCase("C")  && !op2.equalsIgnoreCase("0"));

                        break;





//===========================================================================================================================//	            		





                    //case B
                    case "B":
                        String op3;
                        do {

                            limpa();
                            menu.menu_exibir();
                            op3 = leia.next();



                            //OP - A


                            if(op3.equalsIgnoreCase("A")) {

                                String cargoop;
                                do {
                                    limpa();

                                    System.out.println("DIGITE O CARGO PARA EXIBIR A TABELA");
                                    cargoop = leiaa.readLine();
                                    if (!cargoop.matches("^[\\p{L} ]+$")) {
                                        System.out.println("ENTRADA INVÁLIDA");
                                        Thread.sleep(2 * 1000);
                                    }
                                } while (!cargoop.matches("^[\\p{L} ]+$"));

//					            				 if(!cargoop.matches("^[A-Za-z ]+$")) {
//								            		 
//								            		 System.out.println("ENTRADA INVÁLIDA");
//								            	 
//								            	 }
//					            				 
//					            				 
//								            	
//								            		}while(!cargoop.matches("^[A-Za-z ]+$"));
//					            
                                String op123;

                                String query2 = "SELECT * FROM Servidores WHERE cargo = '"+cargoop+"';";
                                do {
                                    // Execução da consulta e obtenção dos resultados
                                    ResultSet resultSet2 = statement.executeQuery(query2);




                                    if (resultSet2.next()) {




                                        limpa();

                                        System.out.println("\nTABELA SERVIDORES:");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                                        System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", "ID", "NOME", "CPF", "UF", "SALARIO", "SETOR", "CARGO");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------");





                                        while (resultSet2.next()) {


                                            int id_matricula2 = resultSet2.getInt("id_matricula");



                                            String nom_servidor2 = resultSet2.getString("nom_servidor");


                                            String cpf_servidor2 = resultSet2.getString("cpf_servidor");


                                            String sigla_uf2 = resultSet2.getString("sigla_uf");


                                            double val_salario2 = resultSet2.getDouble("val_salario");


                                            String id_sigla2 = resultSet2.getString("id_sigla");

                                            String cargo2 = resultSet2.getString("cargo");




                                            System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", id_matricula2, nom_servidor2, cpf_servidor2, sigla_uf2, val_salario2 , id_sigla2,cargo2);

                                        }



                                    }

                                    else {
                                        System.out.println("\nO CARGO DIGITADO NÃO EXISTE NA TABELA");
                                        Thread.sleep(2 * 1000);
                                        break;
                                    }

                                    System.out.println("DIGITE (0) PARA VOLTAR");
                                    op123 = leia.next();

                                    if(!op123.equalsIgnoreCase("0")) {
                                        System.out.println("ENTRADA INVÁLIDA");
                                        Thread.sleep(1 * 1000);
                                    }


                                }while(!op123.equalsIgnoreCase("0"));



//								            





                            }








                            //OP - B



                            if(op3.equalsIgnoreCase("B")) {

                                String ufop;
                                do {

                                    limpa();
                                    System.out.println("DIGITE A UF PARA EXIBIR A TABELA");
                                    ufop = leiaa.readLine();
//					            		   if (!cargoop.matches("^[\\p{L} ]+$")) {
//					                           System.out.println("ENTRADA INVÁLIDA");
//					                       }
//					                   } while (!cargoop.matches("^[\\p{L} ]+$"));

                                    if(!ufop.matches("^[A-Za-z ]+$")) {

                                        System.out.println("ENTRADA INVÁLIDA");
                                        Thread.sleep(2 * 1000);

                                    }



                                }while(!ufop.matches("^[A-Za-z ]+$"));



                                String query3 = "SELECT * FROM Servidores WHERE sigla_uf = '"+ufop+"';";
                                String op999;
                                do
                                {
                                    // Execução da consulta e obtenção dos resultados
                                    ResultSet resultSet3 = statement.executeQuery(query3);




                                    if (resultSet3.next()) {


                                        limpa();
                                        System.out.println("\nTABELA SERVIDORES:");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                                        System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", "ID", "NOME", "CPF", "UF", "SALARIO", "SETOR", "CARGO");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------");





                                        while (resultSet3.next()) {


                                            int id_matricula2 = resultSet3.getInt("id_matricula");



                                            String nom_servidor2 = resultSet3.getString("nom_servidor");


                                            String cpf_servidor2 = resultSet3.getString("cpf_servidor");


                                            String sigla_uf2 = resultSet3.getString("sigla_uf");


                                            double val_salario2 = resultSet3.getDouble("val_salario");


                                            String id_sigla2 = resultSet3.getString("id_sigla");

                                            String cargo2 = resultSet3.getString("cargo");




                                            System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", id_matricula2, nom_servidor2, cpf_servidor2, sigla_uf2, val_salario2 , id_sigla2,cargo2);

                                        }


                                    }
                                    else {
                                        System.out.println("\nA UF DIGITADA NÃO EXISTE NA TABELA");
                                        Thread.sleep(2 * 1000);
                                        break;
                                    }

                                    System.out.println("DIGITE (0) PARA VOLTAR");
                                    op999 = leia.next();

                                    if(!op999.equalsIgnoreCase("0")) {
                                        System.out.println("ENTRADA INVÁLIDA");
                                        Thread.sleep(1 * 1000);
                                    }


                                }while(!op999.equalsIgnoreCase("0"));




                            }




                            //OP - C


                            if(op3.equalsIgnoreCase("C")) {
                                String salario;
                                do {

//						            	double salario;
//						            
                                    limpa();
//						            		
                                    System.out.println("DIGITE O SALARIO DESEJADO PARA PESQUISA (SERÁ FILTRADO SALARIO >= [MENOR-IGUAL] AO DIGITADO) PARA EXIBIR A TABELA");
                                    salario = leia.next();
//						            		
//						            		   while(!leia.hasNextDouble()) {
//						            			   System.out.println("ENTRANDA INVÁLIDA, DIGITE APENAS NUMEROS");
//						            			   
//						            			   leia.next();
//						            		   }
//						            		salario = leia.nextDouble();
                                    if (!salario.matches("\\d{1,5}")) {

                                        System.out.println("DIGITE APENAS 5 DIGITOS AO MAXIMO");
                                        Thread.sleep(1 * 2000);
                                    }
                                } while (!salario.matches("\\d{1,5}"));
//						            

                                String op555;
                                String query4 = "SELECT * FROM Servidores WHERE val_salario <= '"+salario+"';";
                                do {


                                    // Execução da consulta e obtenção dos resultados
                                    ResultSet resultSet4 = statement.executeQuery(query4);




                                    if (resultSet4.next()) {



                                        System.out.println("\nTABELA SERVIDORES:");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                                        System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", "ID", "NOME", "CPF", "UF", "SALARIO", "SETOR", "CARGO");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------");





                                        while (resultSet4.next()) {


                                            int id_matricula2 = resultSet4.getInt("id_matricula");



                                            String nom_servidor2 = resultSet4.getString("nom_servidor");


                                            String cpf_servidor2 = resultSet4.getString("cpf_servidor");


                                            String sigla_uf2 = resultSet4.getString("sigla_uf");


                                            double val_salario2 = resultSet4.getDouble("val_salario");


                                            String id_sigla2 = resultSet4.getString("id_sigla");

                                            String cargo2 = resultSet4.getString("cargo");




                                            System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", id_matricula2, nom_servidor2, cpf_servidor2, sigla_uf2, val_salario2 , id_sigla2,cargo2);

                                        }


                                    } 	 else {
                                        System.out.println("\nO SALARIO DIGITADO NÃO EXISTE ABAIXO OU IGUAL A ELE NA TABELA");
                                        Thread.sleep(2 * 1000);
                                        break;
                                    }

                                    System.out.println("DIGITE (0) PARA VOLTAR");
                                    op555 = leia.next();

                                    if(!op555.equalsIgnoreCase("0")) {
                                        System.out.println("ENTRADA INVÁLIDA");
                                        Thread.sleep(1 * 1000);
                                    }


                                }while(!op555.equalsIgnoreCase("0"));






                            }







                            if(op3.equalsIgnoreCase("D")) {
                                String setor;

                                do {

                                    limpa();
                                    System.out.println("DIGITE O SETOR PARA EXIBIR A TABELA");
                                    setor = leiaa.readLine();
//						            		   if (!cargoop.matches("^[\\p{L} ]+$")) {
//						                           System.out.println("ENTRADA INVÁLIDA");
//						                       }
//						                   } while (!cargoop.matches("^[\\p{L} ]+$"));

                                    if(!setor.matches("^[A-Za-z ]+$")) {

                                        System.out.println("ENTRADA INVÁLIDA");
                                        Thread.sleep(1 * 2000);

                                    }



                                }while(!setor.matches("^[A-Za-z ]+$"));


                                String op000;
                                String query7 = "SELECT * FROM Servidores WHERE id_sigla = '"+setor+"';";
                                do {
                                    // Execução da consulta e obtenção dos resultados
                                    ResultSet resultSet8 = statement.executeQuery(query7);




                                    if (resultSet8.next()) {



                                        System.out.println("\nTABELA SERVIDORES:");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                                        System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", "ID", "NOME", "CPF", "UF", "SALARIO", "SETOR", "CARGO");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------");





                                        while (resultSet8.next()) {


                                            int id_matricula2 = resultSet8.getInt("id_matricula");



                                            String nom_servidor2 = resultSet8.getString("nom_servidor");


                                            String cpf_servidor2 = resultSet8.getString("cpf_servidor");


                                            String sigla_uf2 = resultSet8.getString("sigla_uf");


                                            double val_salario2 = resultSet8.getDouble("val_salario");


                                            String id_sigla2 = resultSet8.getString("id_sigla");

                                            String cargo2 = resultSet8.getString("cargo");




                                            System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", id_matricula2, nom_servidor2, cpf_servidor2, sigla_uf2, val_salario2 , id_sigla2,cargo2);

                                        }


                                    } 			 else {
                                        System.out.println("\nO SETOR DIGITADO NÃO EXISTE NA TABELA");
                                        Thread.sleep(2 * 1000);
                                        break;
                                    }

                                    System.out.println("DIGITE (0) PARA VOLTAR");
                                    op000 = leia.next();

                                    if(!op000.equalsIgnoreCase("0")) {
                                        System.out.println("ENTRADA INVÁLIDA");
                                        Thread.sleep(1 * 1000);
                                    }


                                }while(!op000.equalsIgnoreCase("0"));




                            }



















































                            //OP





                            if(op3.equalsIgnoreCase("E")) {
                                String especifica;
//					            		 ResultSetMetaData metaData = resultSet.getMetaData();
//								            int columnCount = metaData.getColumnCount();
//								            
//								            for (int i = 1; i <= columnCount; i++) {
//								                String columnName = metaData.getColumnName(i);
//								                System.out.println("Nome da Coluna: " + columnName);
//								            }

//						            	double salario;
//						           
                                limpa();
                                String op566;

                                do {


                                    System.out.println("DIGITE A QUERY ESPECIFICA QUE DESEJA EXIBIR, NECESSITA SER NO FORMATO CORRETO EM SQL");
                                    especifica = leiaa.readLine();
//						            		

                                    try {

                                        PreparedStatement stmt = connection.prepareStatement(especifica);
                                        ResultSet resultSet5 = stmt.executeQuery();
                                        System.out.println("\nTABELA SERVIDORES:");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                                        System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", "ID", "NOME", "CPF", "UF", "SALARIO", "SETOR", "CARGO");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                                        while (resultSet5.next()) {


                                            int id_matricula2 = resultSet5.getInt("id_matricula");



                                            String nom_servidor2 = resultSet5.getString("nom_servidor");


                                            String cpf_servidor2 = resultSet5.getString("cpf_servidor");


                                            String sigla_uf2 = resultSet5.getString("sigla_uf");


                                            double val_salario2 = resultSet5.getDouble("val_salario");


                                            String id_sigla2 = resultSet5.getString("id_sigla");

                                            String cargo2 = resultSet5.getString("cargo");




                                            System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", id_matricula2, nom_servidor2, cpf_servidor2, sigla_uf2, val_salario2 , id_sigla2,cargo2);

                                        }


                                    } catch (SQLException e) {
                                        // Se ocorrer uma exceção, significa que a consulta estava incorreta
                                        System.out.println("QUERY INVÁLIDA, DIGITE A QUERY CORRETAMENTE NO FORMATO SQL");
                                        Thread.sleep(1 * 2000);

                                    }

                                    System.out.println("DIGITE (0) PARA VOLTAR");
                                    op566 = leia.next();

                                }while(!op566.equalsIgnoreCase("0"));
//						            


//						            	String query5 = especifica;

//						            	  Statement statement2 = connection.createStatement();
//								            
//								            // Execução da consulta e obtenção dos resultados
//								            ResultSet resultSet5 = statement.executeQuery(especifica);
//								           
//								            
//								            
//
//								            if (resultSet5.next()) {
//								            	
//								            	
//								            	
//								            	System.out.println("\nTABELA SERVIDORES:");
//									            System.out.println("-----------------------------------------------------------------------------------------------------------");
//									            System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", "ID", "NOME", "CPF", "UF", "SALARIO", "SETOR", "CARGO");
//									            System.out.println("-----------------------------------------------------------------------------------------------------------");
////								                
//									            
//
//								               
//								                
//								                while (resultSet5.next()) {
//									            	
//									            	
//									                int id_matricula2 = resultSet5.getInt("id_matricula");	
//									                
//									        
//									                
//									                String nom_servidor2 = resultSet5.getString("nom_servidor");
//									              
//									                
//									                String cpf_servidor2 = resultSet5.getString("cpf_servidor");
//									               
//									                
//									                String sigla_uf2 = resultSet5.getString("sigla_uf");
//									                
//									                
//									                double val_salario2 = resultSet5.getDouble("val_salario");
//									                
//									                			               
//									                String id_sigla2 = resultSet5.getString("id_sigla");
//									                
//									                String cargo2 = resultSet5.getString("cargo");
//									               
//									                
//									                
//									                
//								                System.out.printf("| %-6s | %-38s | %-11s | %-2s | %-7s | %-5s | %-16s |\n", id_matricula2, nom_servidor2, cpf_servidor2, sigla_uf2, val_salario2 , id_sigla2,cargo2);
//						                	
//								            }
//
//								                
//								       } 			else 
//								    	   				System.out.println("\nQUERY DIGITADA INCORRETAMENTE");
//								            	



                            }





































                            if(!op3.equalsIgnoreCase("A") && !op3.equalsIgnoreCase("B") &&!op3.equalsIgnoreCase("C") && !op3.equalsIgnoreCase("D")&& !op3.equalsIgnoreCase("0") && !op3.equalsIgnoreCase("E")){

                                System.out.println("\nENTRADA INVÁLIDA");
                                Thread.sleep(2 * 1000)


                                ;
                            }



                        }while(!op3.equalsIgnoreCase("0"));












                        break;



                    case "C" :
                        String op100 ;

                        do {

                            limpa();
                            menu.menu_inf();




                            op100 = leia.next();
                            String op101;

                            if(op100.equalsIgnoreCase("1")) {

                                do {
                                    limpa();
                                    menu.menu_tabela();
                                    op101 = leia.next();





                                    if(op101.equalsIgnoreCase("1")) {

                                        String op103;

                                        String query7 = "SELECT id_matricula FROM Servidores ORDER BY id_matricula";
                                        do {
                                            // Execução da consulta e obtenção dos resultados
                                            ResultSet resultSet8 = statement.executeQuery(query7);






                                            if (resultSet8.next()) {

                                                limpa();

                                                System.out.println(" __________________________________");
                                                System.out.println("|                                  |");
                                                System.out.println("| TABELA DE MATRICULAS CADASTRADAS |");
                                                System.out.println("|                                  |");
                                                System.out.println("|__________________________________|\n");

                                                System.out.println("==========");
                                                System.out.printf("| %-6s |\n", "ID");
                                                System.out.println("==========");





                                                while (resultSet8.next()) {


                                                    int id_matricula2 = resultSet8.getInt("id_matricula");






                                                    System.out.printf("| %-6s |\n", id_matricula2);

                                                }


                                            }


                                            System.out.println("DIGITE (0) PARA VOLTAR");
                                            op103 = leia.next();

                                            if(!op103.equalsIgnoreCase("0")) {
                                                System.out.println("ENTRADA INVÁLIDA");
                                                Thread.sleep(1 * 1000);
                                            }

                                        }while(!op103.equalsIgnoreCase("0"));

                                    }


                                    if(op101.equalsIgnoreCase("2")) {
                                        String query7 = "SELECT nom_servidor FROM Servidores ORDER BY nom_servidor";

                                        // Execução da consulta e obtenção dos resultados

                                        String op110;

                                        do {
                                            ResultSet resultSet8 = statement.executeQuery(query7);


                                            if (resultSet8.next()) {

                                                limpa();

                                                System.out.println(" __________________________________");
                                                System.out.println("|                                  |");
                                                System.out.println("|   TABELA DE NOMES CADASTRADOS    |");
                                                System.out.println("|                                  |");
                                                System.out.println("|__________________________________|\n");

                                                System.out.println("==========================================");
                                                System.out.printf("| %-38s |\n", "NOME");
                                                System.out.println("==========================================");





                                                while (resultSet8.next()) {


                                                    String nom_servidor2 = resultSet8.getString("nom_servidor");
//												              






                                                    System.out.printf("| %-38s |\n", nom_servidor2);

                                                }

                                                System.out.println("==========================================");
                                            }


                                            System.out.println("DIGITE (0) PARA VOLTAR");
                                            op110 = leia.next();

                                            if(!op110.equalsIgnoreCase("0")) {
                                                System.out.println("ENTRADA INVÁLIDA");
                                                Thread.sleep(1 * 1000);
                                            }

                                        }while(!op110.equalsIgnoreCase("0"));

                                    }


                                    if(op101.equalsIgnoreCase("3")) {
                                        String query7 = "SELECT id_sigla FROM Setores ORDER BY id_sigla";

                                        // Execução da consulta e obtenção dos resultados

                                        String op110;


                                        do {

                                            ResultSet resultSet8 = statement.executeQuery(query7);


                                            if (resultSet8.next()) {

                                                limpa();

                                                System.out.println(" __________________________________");
                                                System.out.println("|                                  |");
                                                System.out.println("|  TABELA DE SETORES CADASTRADOS   |");
                                                System.out.println("|                                  |");
                                                System.out.println("|__________________________________|\n");

                                                System.out.println("=========");
                                                System.out.printf("| %-5s | \n", "SETOR");
                                                System.out.println("=========");

                                                List<String> id_siglas = new ArrayList<>();

                                                do {
                                                    String id_sigla10 = resultSet8.getString("id_sigla");
                                                    id_siglas.add(id_sigla10);
                                                } while (resultSet8.next());


                                                for (String id_sigla : id_siglas) {
                                                    System.out.printf("| %-5s |\n", id_sigla);
                                                }

                                                System.out.println("=========");
                                            }


                                            System.out.println("DIGITE (0) PARA VOLTAR");
                                            op110 = leia.next();

                                            if(!op110.equalsIgnoreCase("0")) {
                                                System.out.println("ENTRADA INVÁLIDA");
                                                Thread.sleep(1 * 1000);
                                            }

                                        }while(!op110.equalsIgnoreCase("0"));

                                    }






                                    if(op101.equalsIgnoreCase("4")) {
                                        String query102 = "SELECT distinct cargo FROM  Servidores ORDER BY cargo";

                                        // Execução da consulta e obtenção dos resultados

                                        String op110;


                                        do {

                                            ResultSet resultSet8 = statement.executeQuery(query102);


                                            if (resultSet8.next()) {
                                                limpa();

                                                System.out.println(" __________________________________");
                                                System.out.println("|                                  |");
                                                System.out.println("|   TABELA DE CARGOS CADASTRADOS   |");
                                                System.out.println("|                                  |");
                                                System.out.println("|__________________________________|\n");

                                                System.out.println("====================");
                                                System.out.printf("| %-16s | \n", "CARGO");
                                                System.out.println("====================");

                                                List<String> cargos = new ArrayList<>();

                                                do {
                                                    String cargo10 = resultSet8.getString("cargo");
                                                    cargos.add(cargo10);
                                                } while (resultSet8.next());


                                                for (String cargo1: cargos) {
                                                    System.out.printf("| %-16s |\n", cargo1);
                                                }

                                                System.out.println("====================");
                                            }


                                            System.out.println("DIGITE (0) PARA VOLTAR");
                                            op110 = leia.next();

                                            if(!op110.equalsIgnoreCase("0")) {
                                                System.out.println("ENTRADA INVÁLIDA");
                                                Thread.sleep(1 * 1000);
                                            }

                                        }while(!op110.equalsIgnoreCase("0"));

                                    }



                                    if(op101.equalsIgnoreCase("5")) {
                                        String query7 = "SELECT distinct sigla_uf FROM Servidores ORDER BY sigla_uf";

                                        // Execução da consulta e obtenção dos resultados

                                        String op110;

                                        do {

                                            ResultSet resultSet8 = statement.executeQuery(query7);


                                            if (resultSet8.next()) {

                                                limpa();

                                                System.out.println(" __________________________________");
                                                System.out.println("|                                  |");
                                                System.out.println("|     TABELA DE UF CADASTRADAS     |");
                                                System.out.println("|                                  |");
                                                System.out.println("|__________________________________|\n");

                                                System.out.println("======");
                                                System.out.printf("| %-2s | \n", "UF");
                                                System.out.println("======");





                                                while (resultSet8.next()) {


                                                    String uf2 = resultSet8.getString("sigla_uf");
//												              






                                                    System.out.printf("| %-2s |\n", uf2);

                                                }

                                                System.out.println("======");
                                            }


                                            System.out.println("DIGITE (0) PARA VOLTAR");
                                            op110 = leia.next();

                                            if(!op110.equalsIgnoreCase("0")) {
                                                System.out.println("ENTRADA INVÁLIDA");
                                                Thread.sleep(1 * 1000);
                                            }

                                        }while(!op110.equalsIgnoreCase("0"));

                                    }


                                    if (op101.equalsIgnoreCase("6")) {
                                        String query103 = "SELECT distinct cargo, val_salario FROM Servidores ORDER BY val_salario";

                                        Statement statement2 = connection.createStatement();

                                        // Execução da consulta e obtenção dos resultados

                                        String op110;

                                        do {

                                            ResultSet resultSet8 = statement2.executeQuery(query103);

                                            limpa();

                                            System.out.println(" __________________________________");
                                            System.out.println("|                                  |");
                                            System.out.println("|  TABELA DE SALARIOS CADASTRADOS  |");
                                            System.out.println("|                                  |");
                                            System.out.println("|__________________________________|\n");

                                            System.out.println("===============================");
                                            System.out.printf("| %-16s | %-7s |\n", "CARGO", "SALARIO");
                                            System.out.println("===============================");

                                            List<String> cargos = new ArrayList<>();
                                            List<Double> val_salario = new ArrayList<>();

                                            while (resultSet8.next()) {
                                                String cargo10 = resultSet8.getString("cargo");
                                                double salario10 = resultSet8.getDouble("val_salario");

                                                cargos.add(cargo10);
                                                val_salario.add(salario10);

                                                System.out.printf("| %-16s | %-7s |\n", cargo10, salario10);
                                            }

                                            System.out.println("===============================");

                                            System.out.println("DIGITE (0) PARA VOLTAR");
                                            op110 = leia.next();

                                            if (!op110.equalsIgnoreCase("0")) {
                                                System.out.println("ENTRADA INVÁLIDA");
                                                Thread.sleep(1 * 1000);
                                            }




                                        } while (!op110.equalsIgnoreCase("0"));
                                    }


                                    if(!op101.equalsIgnoreCase("0")&& !op101.equalsIgnoreCase("1") && !op101.equalsIgnoreCase("2") && !op101.equalsIgnoreCase("3")
                                            && !op101.equalsIgnoreCase("4") && !op101.equalsIgnoreCase("5") && !op101.equalsIgnoreCase("6")) {

                                        System.out.println("ENTRADA INVALIDA");
                                        Thread.sleep(1 * 2000);
                                    }


                                }while(!op101.equalsIgnoreCase("0"));
                            }



//			            			if(op100.equalsIgnoreCase("2")) {
//			            				
//			            				String op1000;
//			            				
//			            				do {
//			            					
//			            				
//			            				System.out.println(" _________________________ ");
//				            			System.out.println("|                         | ");
//				            			System.out.println("|                         | ");
//				            			System.out.println("|    COLUNAS DO BANCO     | ");
//				            			System.out.println("|                         | ");
//				            			System.out.println("|_________________________|");
//				            			
//				            			System.out.println("\nDIGITE ALGUMAS DAS OPÇÕES ABAIXO:\n"
//				            					+ "1) - VER NOME DAS COLUNAS\n"
//				            					+ "2) - VER TIPO DA VARIAVEL NAS COLUNAS\n"            									            					
//				            					+ "0) - VOLTAR");			            				
//			            				op1000 = leia.next();
//			            				
//			            				if(op1000.equalsIgnoreCase("1")) {
//			            					
//			            					
//			            					
//			            					
//			            				} 
//			            				
//			            				
//			            				
//			            				
//			            				if(op1000.equalsIgnoreCase("2")) {
//			            					
//			            				}
//			            				
//			            				
//			            				
//			            				if(!op1000.equalsIgnoreCase("0") && !op1000.equalsIgnoreCase("1")  && !op1000.equalsIgnoreCase("2")) {
//			            					System.out.println("ENTRADA INVÁLIDA, DIGITE NOVAMENTE");
//			            				}
//			            				
//			            				
//			            				}while(!op1000.equalsIgnoreCase("0"));
//			            			}
//			            			





                            if(!op100.equalsIgnoreCase("1") && !op100.equalsIgnoreCase("0")) {
                                System.out.println("ENTRADA INVÁLIDA");
                                Thread.sleep(2 * 1000);
                            }






                        }while(!op100.equalsIgnoreCase("0"));









































                }
                if(!op1.equalsIgnoreCase("a") && !op1.equalsIgnoreCase("b") && !op1.equalsIgnoreCase("c") && !op1.equalsIgnoreCase("0")) {

                    System.out.println("\nENTRADA INVÁLIDA");
                    Thread.sleep(2 * 1000);
                }


            }while(!op1.equalsIgnoreCase("0"));


            // Fechando recursos
            resultSet.close();
            statement.close();




            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }














    }

    public static void limpa() throws InterruptedException, IOException {
        new ProcessBuilder ("cmd", "/c",  "cls" ).inheritIO().start().waitFor();

    }

}
		
		
		