package com.example.sena;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuleStructure {

    // ========= Keys de módulos =========
    public static final String INTRO = "INTRO";
    public static final String BASICO = "BASICO";
    public static final String INTERMEDIO = "INTERMEDIO";
    public static final String AVANZADO = "AVANZADO";

    // ========= Section IDs INTRO =========
    public static final String INTRO_ABECEDARIO = "INTRO_ABECEDARIO";
    public static final String INTRO_COLORES = "INTRO_COLORES";
    public static final String INTRO_NUMEROS = "INTRO_NUMEROS";
    public static final String INTRO_ALIMENTOS = "INTRO_ALIMENTOS";
    public static final String INTRO_ANIMALES = "INTRO_ANIMALES";
    public static final String INTRO_CUERPO = "INTRO_CUERPO";
    public static final String INTRO_VESTIMENTA = "INTRO_VESTIMENTA";

    // ========= Section IDs BÁSICO =========
    public static final String BAS_SALUDOS = "BAS_SALUDOS";
    public static final String BAS_FRASES = "BAS_FRASES";
    public static final String BAS_FAMILIA = "BAS_FAMILIA";
    public static final String BAS_LUGARES = "BAS_LUGARES";

    // ========= Section IDs INTERMEDIO =========
    public static final String INT_PREGUNTAS = "INT_PREGUNTAS";
    public static final String INT_TIEMPO = "INT_TIEMPO";
    public static final String INT_EMOCIONES = "INT_EMOCIONES";
    public static final String INT_DIRECCIONES = "INT_DIRECCIONES";

    // ========= Section IDs AVANZADO =========
    public static final String AVA_CONECTORES = "AVA_CONECTORES";
    public static final String AVA_OPINIONES = "AVA_OPINIONES";
    public static final String AVA_TRABAJO = "AVA_TRABAJO";
    public static final String AVA_SITUACIONES = "AVA_SITUACIONES";

    public static List<String> getSectionTitles(String moduleKey) {
        switch (safe(moduleKey)) {
            case INTRO:
                return Arrays.asList("Abecedario", "Colores", "Números", "Alimentos", "Animales", "Cuerpo", "Vestimenta");
            case BASICO:
                return Arrays.asList("Saludos", "Frases básicas", "Familia", "Lugares");
            case INTERMEDIO:
                return Arrays.asList("Preguntas", "Tiempo", "Emociones", "Direcciones");
            case AVANZADO:
                return Arrays.asList("Conectores", "Opiniones", "Trabajo / Escuela", "Situaciones");
            default:
                return new ArrayList<>();
        }
    }

    public static List<String> getSectionIds(String moduleKey) {
        switch (safe(moduleKey)) {
            case INTRO:
                return Arrays.asList(
                        INTRO_ABECEDARIO, INTRO_COLORES, INTRO_NUMEROS, INTRO_ALIMENTOS,
                        INTRO_ANIMALES, INTRO_CUERPO, INTRO_VESTIMENTA
                );
            case BASICO:
                return Arrays.asList(BAS_SALUDOS, BAS_FRASES, BAS_FAMILIA, BAS_LUGARES);
            case INTERMEDIO:
                return Arrays.asList(INT_PREGUNTAS, INT_TIEMPO, INT_EMOCIONES, INT_DIRECCIONES);
            case AVANZADO:
                return Arrays.asList(AVA_CONECTORES, AVA_OPINIONES, AVA_TRABAJO, AVA_SITUACIONES);
            default:
                return new ArrayList<>();
        }
    }

    public static List<ContenidoItem> getItems(String sectionId) {
        sectionId = safe(sectionId);

        switch (sectionId) {

            // ===================== INTRO =====================
            case INTRO_ABECEDARIO: {
                List<ContenidoItem> list = new ArrayList<>();
                for (char c = 'A'; c <= 'Z'; c++) {
                    list.add(new ContenidoItem(
                            "ABC_" + c,
                            "Letra " + c,
                            "Seña en LSM para la letra " + c + ".\n\n",
                            String.valueOf(Character.toLowerCase(c)) // ✅ "a", "b", "c"...
                    ));
                }
                return list;
            }



            case INTRO_COLORES:
                return Arrays.asList(
                        new ContenidoItem("COL_ROJO", "Rojo", "Seña en LSM para ROJO.", "lsm_rojo"),
                        new ContenidoItem("COL_AZUL", "Azul", "Seña en LSM para AZUL.", "lsm_azul"),
                        new ContenidoItem("COL_VERDE", "Verde", "Seña en LSM para VERDE.", "lsm_verde"),
                        new ContenidoItem("COL_AMARILLO", "Amarillo", "Seña en LSM para AMARILLO.", "lsm_amarillo"),
                        new ContenidoItem("COL_NEGRO", "Negro", "Seña en LSM para NEGRO.", "lsm_negro")
                );

            case INTRO_NUMEROS: {
                List<ContenidoItem> list = new ArrayList<>();
                for (int n = 1; n <= 10; n++) {
                    list.add(new ContenidoItem(
                            "NUM_" + n,
                            "Número " + n,
                            "Seña en LSM para el número " + n + ".",
                            "lsm_numero_" + n // ej: lsm_numero_1
                    ));
                }
                return list;
            }

            case INTRO_ALIMENTOS:
                return Arrays.asList(
                        new ContenidoItem("ALI_AGUA", "Agua", "Seña en LSM para AGUA.", "lsm_agua"),
                        new ContenidoItem("ALI_PAN", "Pan", "Seña en LSM para PAN.", "lsm_pan"),
                        new ContenidoItem("ALI_LECHE", "Leche", "Seña en LSM para LECHE.", "lsm_leche"),
                        new ContenidoItem("ALI_MANZANA", "Manzana", "Seña en LSM para MANZANA.", "lsm_manzana"),
                        new ContenidoItem("ALI_POLLO", "Pollo", "Seña en LSM para POLLO.", "lsm_pollo")
                );

            case INTRO_ANIMALES:
                return Arrays.asList(
                        new ContenidoItem("ANI_PERRO", "Perro", "Seña en LSM para PERRO.", "lsm_perro"),
                        new ContenidoItem("ANI_GATO", "Gato", "Seña en LSM para GATO.", "lsm_gato"),
                        new ContenidoItem("ANI_PAJARO", "Pájaro", "Seña en LSM para PÁJARO.", "lsm_pajaro"),
                        new ContenidoItem("ANI_PEZ", "Pez", "Seña en LSM para PEZ.", "lsm_pez"),
                        new ContenidoItem("ANI_CONEJO", "Conejo", "Seña en LSM para CONEJO.", "lsm_conejo")
                );

            case INTRO_CUERPO:
                return Arrays.asList(
                        new ContenidoItem("CUE_CABEZA", "Cabeza", "Seña en LSM para CABEZA.", "lsm_cabeza"),
                        new ContenidoItem("CUE_OJOS", "Ojos", "Seña en LSM para OJOS.", "lsm_ojos"),
                        new ContenidoItem("CUE_BOCA", "Boca", "Seña en LSM para BOCA.", "lsm_boca"),
                        new ContenidoItem("CUE_MANO", "Mano", "Seña en LSM para MANO.", "lsm_mano"),
                        new ContenidoItem("CUE_CORAZON", "Corazón", "Seña en LSM para CORAZÓN.", "lsm_corazon")
                );

            case INTRO_VESTIMENTA:
                return Arrays.asList(
                        new ContenidoItem("VES_CAMISA", "Camisa", "Seña en LSM para CAMISA.", "lsm_camisa"),
                        new ContenidoItem("VES_PANTALON", "Pantalón", "Seña en LSM para PANTALÓN.", "lsm_pantalon"),
                        new ContenidoItem("VES_ZAPATOS", "Zapatos", "Seña en LSM para ZAPATOS.", "lsm_zapatos"),
                        new ContenidoItem("VES_PLAYERA", "Playera", "Seña en LSM para PLAYERA.", "lsm_playera"),
                        new ContenidoItem("VES_SUETER", "Suéter", "Seña en LSM para SUÉTER.", "lsm_sueter")
                );

            // ===================== BÁSICO =====================
            case BAS_SALUDOS:
                return Arrays.asList(
                        new ContenidoItem("BAS_HOLA", "Hola", "Seña en LSM para HOLA.", "lsm_hola"),
                        new ContenidoItem("BAS_ADIOS", "Adiós", "Seña en LSM para ADIÓS.", "lsm_adios"),
                        new ContenidoItem("BAS_GRACIAS", "Gracias", "Seña en LSM para GRACIAS.", "lsm_gracias"),
                        new ContenidoItem("BAS_PORFAVOR", "Por favor", "Seña en LSM para POR FAVOR.", "lsm_por_favor"),
                        new ContenidoItem("BAS_PERDON", "Perdón", "Seña en LSM para PERDÓN.", "lsm_perdon")
                );

            case BAS_FRASES:
                return Arrays.asList(
                        new ContenidoItem("BAS_COMOESTAS", "¿Cómo estás?", "Seña en LSM para ¿CÓMO ESTÁS?.", "lsm_como_estas"),
                        new ContenidoItem("BAS_ESTOYBIEN", "Estoy bien", "Seña en LSM para ESTOY BIEN.", "lsm_estoy_bien"),
                        new ContenidoItem("BAS_NOENTIENDO", "No entiendo", "Seña en LSM para NO ENTIENDO.", "lsm_no_entiendo"),
                        new ContenidoItem("BAS_AYUDA", "Ayuda", "Seña en LSM para AYUDA.", "lsm_ayuda"),
                        new ContenidoItem("BAS_NOSVEMOS", "Nos vemos", "Seña en LSM para NOS VEMOS.", "lsm_nos_vemos")
                );

            case BAS_FAMILIA:
                return Arrays.asList(
                        new ContenidoItem("FAM_MAMA", "Mamá", "Seña en LSM para MAMÁ.", "lsm_mama"),
                        new ContenidoItem("FAM_PAPA", "Papá", "Seña en LSM para PAPÁ.", "lsm_papa"),
                        new ContenidoItem("FAM_HERMANO", "Hermano/a", "Seña en LSM para HERMANO/A.", "lsm_hermano"),
                        new ContenidoItem("FAM_ABUELO", "Abuelo/a", "Seña en LSM para ABUELO/A.", "lsm_abuelo"),
                        new ContenidoItem("FAM_FAMILIA", "Familia", "Seña en LSM para FAMILIA.", "lsm_familia")
                );

            case BAS_LUGARES:
                return Arrays.asList(
                        new ContenidoItem("LUG_CASA", "Casa", "Seña en LSM para CASA.", "lsm_casa"),
                        new ContenidoItem("LUG_ESCUELA", "Escuela", "Seña en LSM para ESCUELA.", "lsm_escuela"),
                        new ContenidoItem("LUG_TRABAJO", "Trabajo", "Seña en LSM para TRABAJO.", "lsm_trabajo"),
                        new ContenidoItem("LUG_PARQUE", "Parque", "Seña en LSM para PARQUE.", "lsm_parque"),
                        new ContenidoItem("LUG_HOSPITAL", "Hospital", "Seña en LSM para HOSPITAL.", "lsm_hospital")
                );

            case INT_PREGUNTAS:
                return Arrays.asList(
                        new ContenidoItem("P_QQUE", "¿Qué?", "Seña en LSM para ¿QUÉ?.", "lsm_que"),
                        new ContenidoItem("P_QQUIEN", "¿Quién?", "Seña en LSM para ¿QUIÉN?.", "lsm_quien"),
                        new ContenidoItem("P_QDONDE", "¿Dónde?", "Seña en LSM para ¿DÓNDE?.", "lsm_donde"),
                        new ContenidoItem("P_QCUANDO", "¿Cuándo?", "Seña en LSM para ¿CUÁNDO?.", "lsm_cuando"),
                        new ContenidoItem("P_QPORQUE", "¿Por qué?", "Seña en LSM para ¿POR QUÉ?.", "lsm_porque")
                );

            case INT_TIEMPO:
                return Arrays.asList(
                        new ContenidoItem("T_HOY", "Hoy", "Seña en LSM para HOY.", "lsm_hoy"),
                        new ContenidoItem("T_AYER", "Ayer", "Seña en LSM para AYER.", "lsm_ayer"),
                        new ContenidoItem("T_MANANA", "Mañana", "Seña en LSM para MAÑANA.", "lsm_manana"),
                        new ContenidoItem("T_TARDE", "Tarde", "Seña en LSM para TARDE.", "lsm_tarde"),
                        new ContenidoItem("T_NOCHE", "Noche", "Seña en LSM para NOCHE.", "lsm_noche")
                );

            case INT_EMOCIONES:
                return Arrays.asList(
                        new ContenidoItem("E_FELIZ", "Feliz", "Seña en LSM para FELIZ.", "lsm_feliz"),
                        new ContenidoItem("E_TRISTE", "Triste", "Seña en LSM para TRISTE.", "lsm_triste"),
                        new ContenidoItem("E_ENOJADO", "Enojado", "Seña en LSM para ENOJADO.", "lsm_enojado"),
                        new ContenidoItem("E_CANSADO", "Cansado", "Seña en LSM para CANSADO.", "lsm_cansado"),
                        new ContenidoItem("E_NERVIOSO", "Nervioso", "Seña en LSM para NERVIOSO.", "lsm_nervioso")
                );

            case INT_DIRECCIONES:
                return Arrays.asList(
                        new ContenidoItem("D_DERECHA", "Derecha", "Seña en LSM para DERECHA.", "lsm_derecha"),
                        new ContenidoItem("D_IZQUIERDA", "Izquierda", "Seña en LSM para IZQUIERDA.", "lsm_izquierda"),
                        new ContenidoItem("D_RECTO", "Recto", "Seña en LSM para RECTO.", "lsm_recto"),
                        new ContenidoItem("D_AQUI", "Aquí", "Seña en LSM para AQUÍ.", "lsm_aqui"),
                        new ContenidoItem("D_ALLA", "Allá", "Seña en LSM para ALLÁ.", "lsm_alla")
                );

            // ===================== AVANZADO =====================
            case AVA_CONECTORES:
                return Arrays.asList(
                        new ContenidoItem("C_PORQUE", "Porque", "Seña en LSM para PORQUE.", "lsm_porque"),
                        new ContenidoItem("C_PERO", "Pero", "Seña en LSM para PERO.", "lsm_pero"),
                        new ContenidoItem("C_ENTONCES", "Entonces", "Seña en LSM para ENTONCES.", "lsm_entonces"),
                        new ContenidoItem("C_AUNQUE", "Aunque", "Seña en LSM para AUNQUE.", "lsm_aunque"),
                        new ContenidoItem("C_TAMBIEN", "También", "Seña en LSM para TAMBIÉN.", "lsm_tambien")
                );

            case AVA_OPINIONES:
                return Arrays.asList(
                        new ContenidoItem("O_ME_GUSTA", "Me gusta", "Seña en LSM para ME GUSTA.", "lsm_me_gusta"),
                        new ContenidoItem("O_NO_ME_GUSTA", "No me gusta", "Seña en LSM para NO ME GUSTA.", "lsm_no_me_gusta"),
                        new ContenidoItem("O_CREENO", "Creo / No creo", "Seña en LSM para CREO / NO CREO.", "lsm_creo"),
                        new ContenidoItem("O_IMPORTANTE", "Importante", "Seña en LSM para IMPORTANTE.", "lsm_importante"),
                        new ContenidoItem("O_OPINION", "Opinión", "Seña en LSM para OPINIÓN.", "lsm_opinion")
                );

            case AVA_TRABAJO:
                return Arrays.asList(
                        new ContenidoItem("TR_REUNION", "Reunión", "Seña en LSM para REUNIÓN.", "lsm_reunion"),
                        new ContenidoItem("TR_TAREA", "Tarea", "Seña en LSM para TAREA.", "lsm_tarea"),
                        new ContenidoItem("TR_EXAMEN", "Examen", "Seña en LSM para EXAMEN.", "lsm_examen"),
                        new ContenidoItem("TR_PROYECTO", "Proyecto", "Seña en LSM para PROYECTO.", "lsm_proyecto"),
                        new ContenidoItem("TR_PRESENTAR", "Presentar", "Seña en LSM para PRESENTAR.", "lsm_presentar")
                );

            case AVA_SITUACIONES:
                return Arrays.asList(
                        new ContenidoItem("S_EMERGENCIA", "Emergencia", "Seña en LSM para EMERGENCIA.", "lsm_emergencia"),
                        new ContenidoItem("S_PELIGRO", "Peligro", "Seña en LSM para PELIGRO.", "lsm_peligro"),
                        new ContenidoItem("S_MEDICO", "Médico", "Seña en LSM para MÉDICO.", "lsm_medico"),
                        new ContenidoItem("S_POLICIA", "Policía", "Seña en LSM para POLICÍA.", "lsm_policia"),
                        new ContenidoItem("S_AYUDA", "Necesito ayuda", "Seña en LSM para NECESITO AYUDA.", "lsm_necesito_ayuda")
                );

            default:
                return new ArrayList<>();
        }
    }

    public static int getTotalItemsForModule(String moduleKey) {
        moduleKey = (moduleKey == null) ? "" : moduleKey.trim().toUpperCase();
        List<String> sectionIds = getSectionIds(moduleKey);

        int total = 0;
        for (String sectionId : sectionIds) {
            total += getItems(sectionId).size();
        }
        return total;
    }

    private static String safe(String s) {
        return (s == null) ? "" : s.trim().toUpperCase();
    }
}
