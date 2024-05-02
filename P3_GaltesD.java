
import java.util.Scanner;

public class P3_GaltesD {

    // Declarem constants amb els valors que no canviaran en el programa
    public static final int TIS_MIN = 100000;
    public static final int TIS_MAX = 999999;

    public static final int SIMPTOMA_MIN = 0;
    public static final int SIMPTOMA_MAX = 3;

    public static final int EXPLORACIO_MIN_DOLOR = 0;
    public static final int EXPLORACIO_MAX_DOLOR = 3;

    public static final int EXPLORACIO_MIN_LESIO = 10;
    public static final int EXPLORACIO_MAX_LESIO = 13;

    public static final int EXPLORACIO_MIN_FEBRE = 20;
    public static final int EXPLORACIO_MAX_FEBRE = 23;

    public static final int EXPLORACIO_MIN_CONFUSIO = 30;
    public static final int EXPLORACIO_MAX_CONFUSIO = 33;

    public static final int PRIORITAT_MIN = 0;
    public static final int PRIORITAT_MAX = 5;

    public static final int TEMPERATURA_MIN = 27;
    public static final int TEMPERATURA_MAX = 45;

    public static final int DOLOR = 0;
    public static final int LESIO_TRAUMA = 1;
    public static final int FEBRE_ALTA = 2;
    public static final int CONFUSIO = 3;
    public static final int DOL_TORACIC = 00;
    public static final int DOL_ABDOMINAL = 01;
    public static final int DOL_CAP = 02;
    public static final int MIGRANYA = 03;
    public static final int FRACTURA = 10;
    public static final int BALA = 11;
    public static final int CREMADA = 12;
    public static final int LES_CEREBRAL = 13;
    public static final int PNEUMONIA = 20;
    public static final int MENINGITIS = 21;
    public static final int INF_VIRAL = 22;
    public static final int ALERGIA = 23;
    public static final int DROGUES = 30;
    public static final int DESHIDRATACIO = 31;
    public static final int ACCIDENT = 32;
    public static final int HIPOGLUCEMIA = 33;
    public static final String DOLOR_NOM = "Dolor";
    public static final String DOLTORACIC_NOM = "Dolor toracic";
    public static final String DOLABDOMINAL_NOM = "Dolor abdominal";
    public static final String DOLCAP_NOM = "Dolor cap";
    public static final String MIGRANYA_NOM = "Migranya";
    public static final String LESTRAUMA_NOM = "Lesio traumatica";
    public static final String FEBREALTA_NOM = "Febre alta";
    public static final String CONFUSIO_NOM = "Confusio o desorientacio";
    public static final String FRACTURA_NOM = "Fractura ossia";
    public static final String BALA_NOM = "Ferida de bala";
    public static final String CREMADA_NOM = "Cremada";
    public static final String LESCEREBRAL_NOM = "Lesio cerebral traumatica";
    public static final String PNEUMONIA_NOM = "Pneumonia";
    public static final String MENINGITIS_NOM = "Meningitis";
    public static final String INFVIRAL_NOM = "Infeccio viral";
    public static final String ALERGIA_NOM = "Reaccio al·lergica";
    public static final String DROGUES_NOM = "Intoxicacio per drogues o alcohol";
    public static final String DESHIDRATACIO_NOM = "Deshidratacio severa";
    public static final String ACCIDENT_NOM = "Accident cerebrovascular";
    public static final String HIPOGLUCEMIA_NOM = "Hipoglucemia severa";

    public static final int MAX_INTENTS = 3;

    public static final int MAX_PACIENTS = 10;

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        int numPacients = 0; //iniciem el comptador en 0
        int aux;
        String nomExploracio = "";
        String nomSimptoma = "";

        boolean introduirPacient = false;
        boolean maxPacientsIntroduits = false; //Variable per controlar l'error que apareix si introduim més de 10 pacients

        int comptadorDolor = 0;
        int comptadorLesioTrauma = 0;
        int comptadorFebreAlta = 0;
        int comptadorConfusio = 0;
        int comptadorPrioritat0 = 0;
        int comptadorPrioritat1 = 0;
        int comptadorPrioritat2 = 0;
        int comptadorPrioritat3 = 0;
        int comptadorPrioritat4 = 0;
        int comptadorPrioritat5 = 0;

        //ARRAYS
        int i = 0;
        int[] tis = new int[MAX_PACIENTS];
        int[] simptoma = new int[MAX_PACIENTS];
        int[] exploracio = new int[MAX_PACIENTS];
        int[] nivellPrioritat = new int[MAX_PACIENTS];
        int[] temperaturaActual = new int[MAX_PACIENTS];

        do {

            int intents = 0;
            boolean dadesCorrectes = true; // Variable per controlar si les dades són correctes
            boolean intentsSuperats = false; // Variable per controlar si s'han superat els intents (el programa acabarà)

            do {
                System.out.println("Si us plau, introdueix el TIS del pacient: ");
                if (lector.hasNextInt()) { //comprovem que el nombre introduit és un valor sencer
                    tis[i] = lector.nextInt(); //llegim el valor
                    if (tis[i] < TIS_MIN || tis[i] > TIS_MAX) { //comprovem que estigui entre els limits que hem indicat
                        System.out.println("Numero de TIS incorrecte, si us plau revisa les dades");
                        dadesCorrectes = false;
                        intents++; //sumem 1 intent cada cop que dadesCorrectes és fals
                    } else {
                        dadesCorrectes = true; //podem seguir amb el programa
                    }
                } else {
                    System.out.println("Entrada no vàlida. Si us plau, introdueix un nombre enter.");
                    lector.nextLine();
                    dadesCorrectes = false;
                    intents++; //sumem 1 intent perquè dadesCorrectes és fals
                }

                if (intents >= MAX_INTENTS) { //si el nombre d'intents supera el maxim, proposarem introduir mes pacients
                    System.out.println("S'han superat el nombre màxim d'intents. Vols introduir un altre pacient? (1: Si, 0: No)");
                    if (lector.hasNextInt()) {
                        int resposta = lector.nextInt();
                        if (resposta == 1) {
                            introduirPacient = true;
                        } else {
                            introduirPacient = false; // Aquí canviem el valor a false quan l'usuari no vol més pacients, acabem el programa
                        }
                    } else {
                        introduirPacient = false; // També canviem el valor a false si l'entrada no és un número, acabem el programa
                        lector.nextLine();// Neteja l'entrada
                    }
                    intentsSuperats = true;
                }

            } while (!dadesCorrectes && !intentsSuperats); //aquest bloc es donara mentre les dades NO siguin correctes i NO haguem superat el nombre d'intents

            if (dadesCorrectes && !intentsSuperats) { //nomes passarem a aquest bloc si les dades son correctes i el nombre d'intents NO hagi estat superat
                intents = 0; //reiniciem el comptador en cada bloc
                do {
                    System.out.println("Si us plau, introdueix el simptoma del pacient: \n 0. Dolor. \n 1. Lesio traumatica. \n 2. Febre alta. \n 3. Confusio o desorientacio: ");
                    if (lector.hasNextInt()) {
                        simptoma[i] = lector.nextInt();
                        if (simptoma[i] < SIMPTOMA_MIN || simptoma[i] > SIMPTOMA_MAX) { //comprovem que el valor no superi els limits
                            System.out.println("Simptoma incorrecte, si us plau tria un del llistat.");
                            dadesCorrectes = false;
                            intents++;
                        } else {
                            dadesCorrectes = true;
                        }
                    } else {
                        System.out.println("Entrada no vàlida. Si us plau, introdueix un valor numèric.");
                        lector.nextLine();
                        dadesCorrectes = false;
                        intents++;
                    }

                    if (intents >= MAX_INTENTS) {
                        System.out.println("S'han superat el nombre màxim d'intents. Vols introduir un altre pacient? (1: Si, 0: No)");
                        if (lector.hasNextInt()) {
                            int resposta = lector.nextInt();
                            if (resposta == 1) {
                                introduirPacient = true;
                            } else {
                                introduirPacient = false; // L'usuari no vol més pacients
                            }
                        } else {
                            introduirPacient = false; // L'entrada no es vàlida, per tant acabem el programa
                            lector.nextLine(); // Neteja l'entrada
                        }
                        intentsSuperats = true;
                    }

                } while (!dadesCorrectes && !intentsSuperats);

                if (dadesCorrectes && !intentsSuperats) {
                    intents = 0;
                    do {
                        switch (simptoma[i]) {
                            case DOLOR:
                                nomSimptoma = DOLOR_NOM;
                                System.out.println("Indica l'exploracio inicial: \n 00. Dolor toracic \n 01. Dolor abdominal \n 02. Dolor de cap \n 03. Migranya");
                                exploracio[i] = lector.nextInt();
                                if (exploracio[i] < EXPLORACIO_MIN_DOLOR || exploracio[i] > EXPLORACIO_MAX_DOLOR) {
                                    System.out.println("Valor d'exploracio invalid, si us plau, escolleix un de la llista.");
                                    dadesCorrectes = false;
                                    intents++;
                                } else {
                                    dadesCorrectes = true;
                                    comptadorDolor++;
                                }

                                switch (exploracio[i]) {
                                    case DOL_TORACIC:
                                        nomExploracio = DOLTORACIC_NOM;
                                        break;

                                    case DOL_ABDOMINAL:
                                        nomExploracio = DOLABDOMINAL_NOM;
                                        break;

                                    case DOL_CAP:
                                        nomExploracio = DOLCAP_NOM;
                                        break;

                                    case MIGRANYA:
                                        nomExploracio = MIGRANYA_NOM;
                                        break;
                                }

                                break;

                            case LESIO_TRAUMA:
                                nomSimptoma = LESTRAUMA_NOM;
                                System.out.println("Indica l'exploracio inicial: \n 10. Fractura ossia \n 11. Ferida de bala \n 12. Cremada \n 13. Lesio cerebral traumatica");
                                exploracio[i] = lector.nextInt();
                                if (exploracio[i] < EXPLORACIO_MIN_LESIO || exploracio[i] > EXPLORACIO_MAX_LESIO) {
                                    System.out.println("Valor d'exploracio invalid, si us plau, escolleix un de la llista.");
                                    dadesCorrectes = false;
                                    intents++;
                                } else {
                                    dadesCorrectes = true;
                                    comptadorLesioTrauma++;
                                }

                                switch (exploracio[i]) {
                                    case FRACTURA:
                                        nomExploracio = FRACTURA_NOM;
                                        break;
                                    case BALA:
                                        nomExploracio = BALA_NOM;
                                        break;
                                    case CREMADA:
                                        nomExploracio = CREMADA_NOM;
                                        break;
                                    case LES_CEREBRAL:
                                        nomExploracio = LESCEREBRAL_NOM;
                                        break;
                                }

                                break;

                            case FEBRE_ALTA:
                                nomSimptoma = FEBREALTA_NOM;
                                System.out.println("Indica l'exploracio inicial: \n 20. Pneumonia \n 21. Meningitis \n 22. Infeccio viral \n 23. Reaccio al·lergica");
                                exploracio[i] = lector.nextInt();
                                if (exploracio[i] < EXPLORACIO_MIN_FEBRE || exploracio[i] > EXPLORACIO_MAX_FEBRE) {
                                    System.out.println("Valor d'exploracio invalid, si us plau, escolleix un de la llista.");
                                    dadesCorrectes = false;
                                    intents++;
                                } else {
                                    dadesCorrectes = true;
                                    comptadorFebreAlta++;
                                }

                                switch (exploracio[i]) {
                                    case PNEUMONIA:
                                        nomExploracio = PNEUMONIA_NOM;
                                        break;

                                    case MENINGITIS:
                                        nomExploracio = MENINGITIS_NOM;
                                        break;

                                    case INF_VIRAL:
                                        nomExploracio = INFVIRAL_NOM;
                                        break;

                                    case ALERGIA:
                                        nomExploracio = ALERGIA_NOM;
                                        break;

                                }

                                break;

                            case CONFUSIO:
                                nomSimptoma = CONFUSIO_NOM;
                                System.out.println("Indica l'exploracio inicial: \n 30. Intoxicacio per drogues o alcohol \n 31. Deshidratacio severa \n 32. Accident cerebrovascular \n 33. Hipoglucemia severa");
                                exploracio[i] = lector.nextInt();
                                if (exploracio[i] < EXPLORACIO_MIN_CONFUSIO || exploracio[i] > EXPLORACIO_MAX_CONFUSIO) {
                                    System.out.println("Valor d'exploracio invalid, si us plau, escolleix un de la llista.");
                                    dadesCorrectes = false;
                                    intents++;
                                } else {
                                    dadesCorrectes = true;
                                    comptadorConfusio++;
                                }

                                switch (exploracio[i]) {
                                    case DROGUES:
                                        nomExploracio = DROGUES_NOM;
                                        break;

                                    case DESHIDRATACIO:
                                        nomExploracio = DESHIDRATACIO_NOM;
                                        break;

                                    case ACCIDENT:
                                        nomExploracio = ACCIDENT_NOM;
                                        break;

                                    case HIPOGLUCEMIA:
                                        nomExploracio = HIPOGLUCEMIA_NOM;
                                        break;
                                }

                                break;
                        }

                        if (intents >= MAX_INTENTS) {
                            System.out.println("S'han superat el nombre màxim d'intents. Vols introduir un altre pacient? (1: Si, 0: No)");
                            if (lector.hasNextInt()) {
                                int resposta = lector.nextInt();
                                if (resposta == 1) {
                                    introduirPacient = true;
                                } else {
                                    introduirPacient = false;
                                }
                            } else {
                                introduirPacient = false;
                                lector.nextLine();
                            }
                            intentsSuperats = true;
                        }

                    } while (!dadesCorrectes && !intentsSuperats);
                }
            }

            if (dadesCorrectes && !intentsSuperats) {
                intents = 0;
                do {
                    System.out.println("Si us plau, indica el nivell de prioritat: \n 0. No prioritari \n 1. Prioritat molt baixa \n 2. Prioritat baixa \n 3. Prioritat mitja \n 4. Prioritat alta \n 5. Maxima prioritat");
                    if (lector.hasNextInt()) {
                        nivellPrioritat[i] = lector.nextInt();
                        if (nivellPrioritat[i] < PRIORITAT_MIN || nivellPrioritat[i] > PRIORITAT_MAX) {
                            System.out.println("Valor invalid, si us plau introdueix un de la llista.");
                            dadesCorrectes = false;
                            intents++;
                        } else {
                            dadesCorrectes = true;
                        }
                    } else {
                        System.out.println("Entrada no vàlida. Si us plau, introdueix un valor numèric.");
                        dadesCorrectes = false;
                        lector.nextLine();
                        intents++;
                    }

                    if (intents >= MAX_INTENTS) {
                        System.out.println("S'han superat el nombre màxim d'intents. Vols introduir un altre pacient? (1: Si, 0: No)");
                        if (lector.hasNextInt()) {
                            int resposta = lector.nextInt();
                            if (resposta == 1) {
                                introduirPacient = true;
                            } else {
                                introduirPacient = false; // Aquí canviem el valor a false quan l'usuari no vol més pacients
                            }
                        } else {
                            introduirPacient = false; // També canviem el valor a false si l'entrada no és un número
                            lector.nextLine(); // Neteja l'entrada
                        }
                        intentsSuperats = true;
                    }

                } while (!dadesCorrectes && !intentsSuperats);
            }

            if (dadesCorrectes && !intentsSuperats) {
                intents = 0;
                do {
                    System.out.println("Si us plau, indica la temperatura corporal actual (entre 27 i 45 graus Celsius): ");
                    if (lector.hasNextInt()) {
                        temperaturaActual[i] = lector.nextInt();
                        if (temperaturaActual[i] < TEMPERATURA_MIN || temperaturaActual[i] > TEMPERATURA_MAX) {
                            System.out.println("Valor de temperatura incorrecte, si us plau, introdueix un valor entre 27 i 45.");
                            dadesCorrectes = false;
                            intents++;
                        } else {
                            dadesCorrectes = true;

                            switch (nivellPrioritat[i]) {
                                case 0:
                                    comptadorPrioritat0++;
                                    break;
                                case 1:
                                    comptadorPrioritat1++;
                                    break;
                                case 2:
                                    comptadorPrioritat2++;
                                    break;
                                case 3:
                                    comptadorPrioritat3++;
                                    break;
                                case 4:
                                    comptadorPrioritat4++;
                                    break;
                                case 5:
                                    comptadorPrioritat5++;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Entrada no vàlida. Si us plau, introdueix un nombre enter.");
                        dadesCorrectes = false;
                        intents++;
                        lector.nextLine();
                    }

                    if (intents >= MAX_INTENTS) {
                        System.out.println("S'han superat el nombre màxim d'intents. Vols introduir un altre pacient? (1: Si, 0: No)");
                        if (lector.hasNextInt()) {
                            int resposta = lector.nextInt();
                            if (resposta == 1) {
                                introduirPacient = true;
                            } else {
                                introduirPacient = false;
                            }
                        } else {
                            introduirPacient = false;
                            lector.nextLine();
                        }
                        intentsSuperats = true;
                    }

                } while (!dadesCorrectes && !intentsSuperats);
            }

            if (dadesCorrectes && !intentsSuperats) {
                numPacients++;
                if (numPacients >= MAX_PACIENTS) {
                    maxPacientsIntroduits = true;
                } else {
                    System.out.println("Vols introduir un altre pacient? (1: Si, 0: No)");
                    if (lector.hasNextInt()) {
                        int resposta = lector.nextInt();
                        if (resposta == 1) {
                            introduirPacient = true;
                            i++;
                        } else {
                            introduirPacient = false;
                        }
                    } else {
                        introduirPacient = false;
                    }
                }
            }

        } while (introduirPacient && !maxPacientsIntroduits);

        System.out.println("\nLlista de pacients introduïts:");
        System.out.println("-------------------------------");

        System.out.println("TIS                Simptoma                    Exploracio Inicial              Nivell prioritat              Temperatura corporal");
        for (int j = 0; j < numPacients; j++) {
            // Obtenim el nom del simptoma
            switch (simptoma[j]) {
                case DOLOR:
                    nomSimptoma = DOLOR_NOM;
                    break;
                case LESIO_TRAUMA:
                    nomSimptoma = LESTRAUMA_NOM;
                    break;
                case FEBRE_ALTA:
                    nomSimptoma = FEBREALTA_NOM;
                    break;
                case CONFUSIO:
                    nomSimptoma = CONFUSIO_NOM;
                    break;
            }

            // Obtenim el nom de l'exploracio
            switch (exploracio[j]) {
                case DOL_TORACIC:
                    nomExploracio = DOLTORACIC_NOM;
                    break;
                case DOL_ABDOMINAL:
                    nomExploracio = DOLABDOMINAL_NOM;
                    break;
                case DOL_CAP:
                    nomExploracio = DOLCAP_NOM;
                    break;
                case MIGRANYA:
                    nomExploracio = MIGRANYA_NOM;
                    break;
                case FRACTURA:
                    nomExploracio = FRACTURA_NOM;
                    break;
                case BALA:
                    nomExploracio = BALA_NOM;
                    break;
                case CREMADA:
                    nomExploracio = CREMADA_NOM;
                    break;
                case LES_CEREBRAL:
                    nomExploracio = LESCEREBRAL_NOM;
                    break;
                case PNEUMONIA:
                    nomExploracio = PNEUMONIA_NOM;
                    break;
                case MENINGITIS:
                    nomExploracio = MENINGITIS_NOM;
                    break;
                case INF_VIRAL:
                    nomExploracio = INFVIRAL_NOM;
                    break;
                case ALERGIA:
                    nomExploracio = ALERGIA_NOM;
                    break;
                case DROGUES:
                    nomExploracio = DROGUES_NOM;
                    break;
                case DESHIDRATACIO:
                    nomExploracio = DESHIDRATACIO_NOM;
                    break;
                case ACCIDENT:
                    nomExploracio = ACCIDENT_NOM;
                    break;
                case HIPOGLUCEMIA:
                    nomExploracio = HIPOGLUCEMIA_NOM;
                    break;

            }

            System.out.println(tis[j] + "            " + nomSimptoma + "               " + nomExploracio + "                   " + nivellPrioritat[j] + "                       " + temperaturaActual[j]);
        }

        System.out.println("Vols consultar per tipus de simptoma? (si: 1 / no: 2)");
        int respostaSimptoma = lector.nextInt();
        if (respostaSimptoma == 1) {
            System.out.print("Quin tipus de simptoma? Premi un numero del 0 al 3: ");
            int decisioUsuari = lector.nextInt();
            System.out.println("Dades dels pacients amb simptoma " + decisioUsuari + ":");
            System.out.println("TIS        Simptoma       Exploracio Inicial      Nivell prioritat      Temperatura corporal");

            for (int k = 0; k < (numPacients - 1); k++) { //recorrem tot l'array de numPacients. Es resta 1 perquè no necessitem comparar l'últim valor (ja serà més gran que el següent)
                for (int j = 0; j < (numPacients - 1); j++) { //en aquest cas, restem 1 per assegurar-nos que no buscarem un valor fora de l'array 
                    if (nivellPrioritat[j] < nivellPrioritat[j + 1]) { //valorem si el valor de temperatura actual és menor o major al següent de la llista
                        // Hem d'intercanviar els valors de tots els arrays perquè vagin sincronitzats amb la temperatura
                        int tempTis = tis[j]; //declarem variables temporals per no perdre el valor
                        tis[j] = tis[j + 1];
                        tis[j + 1] = tempTis;

                        int tempSimptoma = simptoma[j];
                        simptoma[j] = simptoma[j + 1];
                        simptoma[j + 1] = tempSimptoma;

                        int tempExploracio = exploracio[j];
                        exploracio[j] = exploracio[j + 1];
                        exploracio[j + 1] = tempExploracio;

                        int tempNivellPrioritat = nivellPrioritat[j];
                        nivellPrioritat[j] = nivellPrioritat[j + 1];
                        nivellPrioritat[j + 1] = tempNivellPrioritat;

                        int tempTemperatura = temperaturaActual[j];
                        temperaturaActual[j] = temperaturaActual[j + 1];
                        temperaturaActual[j + 1] = tempTemperatura;
                    }
                }
            }

            for (int j = 0; j < numPacients; j++) {
                if (simptoma[j] == decisioUsuari) {

                    switch (simptoma[j]) {

                        case DOLOR:
                            nomSimptoma = DOLOR_NOM;
                            break;
                        case LESIO_TRAUMA:
                            nomSimptoma = LESTRAUMA_NOM;
                            break;
                        case FEBRE_ALTA:
                            nomSimptoma = FEBREALTA_NOM;
                            break;
                        case CONFUSIO:
                            nomSimptoma = CONFUSIO_NOM;
                            break;
                    }

                    switch (exploracio[j]) {

                        case DOL_TORACIC:
                            nomExploracio = DOLTORACIC_NOM;
                            break;
                        case DOL_ABDOMINAL:
                            nomExploracio = DOLABDOMINAL_NOM;
                            break;
                        case DOL_CAP:
                            nomExploracio = DOLCAP_NOM;
                            break;
                        case MIGRANYA:
                            nomExploracio = MIGRANYA_NOM;
                            break;
                        case FRACTURA:
                            nomExploracio = FRACTURA_NOM;
                            break;
                        case BALA:
                            nomExploracio = BALA_NOM;
                            break;
                        case CREMADA:
                            nomExploracio = CREMADA_NOM;
                            break;
                        case LES_CEREBRAL:
                            nomExploracio = LESCEREBRAL_NOM;
                            break;
                        case PNEUMONIA:
                            nomExploracio = PNEUMONIA_NOM;
                            break;
                        case MENINGITIS:
                            nomExploracio = MENINGITIS_NOM;
                            break;
                        case INF_VIRAL:
                            nomExploracio = INFVIRAL_NOM;
                            break;
                        case ALERGIA:
                            nomExploracio = ALERGIA_NOM;
                            break;
                        case DROGUES:
                            nomExploracio = DROGUES_NOM;
                            break;
                        case DESHIDRATACIO:
                            nomExploracio = DESHIDRATACIO_NOM;
                            break;
                        case ACCIDENT:
                            nomExploracio = ACCIDENT_NOM;
                            break;
                        case HIPOGLUCEMIA:
                            nomExploracio = HIPOGLUCEMIA_NOM;
                            break;
                    }

                    System.out.println(tis[j] + "     " + nomSimptoma + "          " + nomExploracio + "          " + nivellPrioritat[j] + "        " + temperaturaActual[j]);
                }
            }
        }

        System.out.println("Vols veure un resum estadístic de les dades? (Si: 1 / no: 0)");
        int respostaResum = lector.nextInt();
        if (respostaResum == 1) {
            System.out.println("Numero de pacients introduits: " + numPacients + ".");
            System.out.println("Numero pacients per simptoma: ");
            System.out.println(DOLOR_NOM + " : " + comptadorDolor);
            System.out.println(LESTRAUMA_NOM + " : " + comptadorLesioTrauma);
            System.out.println(FEBREALTA_NOM + " : " + comptadorFebreAlta);
            System.out.println(CONFUSIO_NOM + " : " + comptadorConfusio);
            System.out.println("Numero de pacients per nivell de Prioritat: ");
            System.out.println("Priortitat 5: " + comptadorPrioritat5);
            System.out.println("Priortitat 4: " + comptadorPrioritat4);
            System.out.println("Priortitat 3: " + comptadorPrioritat3);
            System.out.println("Priortitat 2: " + comptadorPrioritat2);
            System.out.println("Priortitat 1: " + comptadorPrioritat1);
            System.out.println("Priortitat 0: " + comptadorPrioritat0);

        }
    }
}
