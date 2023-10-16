

public class Banco_menu {



    public void menu_inicial () {
        System.out.println("============================================================================\n");
        System.out.println("SEJA BEM VINDO AO MENU DE CONSULTA DA CENTRAL GTI DA ASSEMBLEIA LEGISLATIVA\n");
        System.out.println("============================================================================\n");


        System.out.println("DIGITE ALGUMAS DAS OPÇÕES ABAIXO:\n"
                + "A)- LOCALIZAR SERVIDOR\n"
                + "B)- EXIBIR TABELA ESPECIFICA DE SERVIDORES\n"
                + "C)- INFORMARÇÕES DO BANCO\n"
                + "0)- FECHA PROGRAMA");

    }

    public void menu_loc () {
        System.out.println("==============================");
        System.out.println("   LOCALIZADOR DE SERVIDOR");
        System.out.println("==============================");

        System.out.println("\nESCOLHA UMA DAS OPÇÕES ABAIXO PARA CONSEGUIR LOCALIZAR O SERVIDOR:\n"
                + "A)- MATRICULA\n"
                + "B)- NOME\n"
                + "C)- CPF\n"
                + "0)- VOLTAR");

    }

    public void menu_exibir () {
        System.out.println("\n=========================================");
        System.out.println("EXIBIR TABELA ESPECIFICA DE SERVIDORES");
        System.out.println("=========================================");

        System.out.println("\nESCOLHA UMA DAS OPÇÕES ABAIXO PARA EXIBIR TABELA ESPECIFICA DE SERVIDORES\n"
                + "A)- FILTRAR POR CARGO\n"
                + "B)- FILTRAR POR UF\n"
                + "C)- FILTRAR POR SALARIO\n"
                + "D)- FILTRAR POR SETOR\n"
                + "E)- FILTRAR POR QUERY ESPECIFICA\n"
                + "0)- VOLTAR");

    }

    public void menu_inf () {
        System.out.println(" _________________________ ");
        System.out.println("|                         | ");
        System.out.println("|                         | ");
        System.out.println("|  INFORMARÇÕES DO BANCO  | ");
        System.out.println("|                         | ");
        System.out.println("|_________________________|");

        System.out.println("\n1) - TABELAS\n"
                + "0) - VOLTAR");
    }

    public void menu_tabela () {
        System.out.println(" _________________________ ");
        System.out.println("|                         | ");
        System.out.println("|                         | ");
        System.out.println("|    TABELAS DO BANCO     | ");
        System.out.println("|                         | ");
        System.out.println("|_________________________|");



        System.out.println("\nDIGITE ALGUMAS DAS OPÇÕES ABAIXO:\n"
                + "1) - MATRICULA\n"
                + "2) - NOME\n"
                + "3) - SETOR\n"
                + "4) - CARGO\n"
                + "5) - UF\n"
                + "6) - SALARIO\n"
                + "0) - VOLTAR");
    }











}
