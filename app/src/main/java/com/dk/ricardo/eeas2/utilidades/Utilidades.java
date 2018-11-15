package com.dk.ricardo.eeas2.utilidades;

public class Utilidades
{
    //constantes campos tabla redesSociales
    public static final String TABLA_REDES_SOCIALES="redesSociales";
    public static final String CAMPO_PK_AMIGO="idRed";
    public static final String CAMPO_REDES_NOMBRE="nombre";

    public static final String CREAR_TABLA_REDES_SOCIALES="CREATE TABLE "+TABLA_REDES_SOCIALES+" ("+CAMPO_PK_AMIGO+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_REDES_NOMBRE+" TEXT)";

    //constantes campos tabla Enfermedades Inmunes
    public static final String TABLA_ENF_INMUNES="enfInmunes";
    public static final String CAMPO_PK_ENF_INMUNES="idEnfInmunes";
    public static final String CAMPO_ENF_INMUNES_NOMBRE="nombre";

    public static final String CREAR_TABLA_ENF_INMUNES="CREATE TABLE "+TABLA_ENF_INMUNES+" ("+CAMPO_PK_ENF_INMUNES+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_ENF_INMUNES_NOMBRE+" TEXT)";

    //constantes campos tabla Alergias
    public static final String TABLA_ALERGIAS="alergias";
    public static final String CAMPO_PK_ALERGIAS="idAlergias";
    public static final String CAMPO_ALERGIAS_NOMBRE="nombre";

    public static final String CREAR_TABLA_ALERGIAS="CREATE TABLE "+TABLA_ALERGIAS+" ("+CAMPO_PK_ALERGIAS+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_ALERGIAS_NOMBRE+" TEXT)";

    //constantes campos tabla Problemas Circulatorios
    public static final String TABLA_PROB_CIRCULATORIOS="probCirculatorios";
    public static final String CAMPO_PK_PROB_CIRCULATORIOS="idProbCirculatorios";
    public static final String CAMPO_PROB_CIRCULATORIOS_NOMBRE="nombre";

    public static final String CREAR_TABLA_PROB_CIRCULATORIOS="CREATE TABLE "+TABLA_PROB_CIRCULATORIOS+
            " ("+CAMPO_PK_PROB_CIRCULATORIOS+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_PROB_CIRCULATORIOS_NOMBRE+
            " TEXT)";

    //constantes campos tabla Fracturas
    public static final String TABLA_FRACTURAS="fracturas";
    public static final String CAMPO_PK_FRACTURAS="idFracturas";
    public static final String CAMPO_FRACTURAS_NOMBRE="nombre";

    public static final String CREAR_TABLA_FRACTURAS="CREATE TABLE "+TABLA_FRACTURAS+" ("+CAMPO_PK_FRACTURAS+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_FRACTURAS_NOMBRE+" TEXT)";

    //constantes campos tabla Cirugias
    public static final String TABLA_CIRUGIAS="cirugias";
    public static final String CAMPO_PK_CIRUGIAS="idCirugias";
    public static final String CAMPO_CIRUGIAS_NOMBRE="nombre";

    public static final String CREAR_TABLA_CIRUGIAS="CREATE TABLE "+TABLA_CIRUGIAS+" ("+CAMPO_PK_CIRUGIAS+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_CIRUGIAS_NOMBRE+" TEXT)";

    //constantes campos tabla Enfermedades
    public static final String TABLA_ENFERMEDADES="enfermedades";
    public static final String CAMPO_PK_ENFERMEDADES="idEnfermedades";
    public static final String CAMPO_ENFERMEDADES_NOMBRE="nombre";

    public static final String CREAR_TABLA_ENFERMEDADES="CREATE TABLE "+TABLA_ENFERMEDADES+" ("+CAMPO_PK_ENFERMEDADES+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_ENFERMEDADES_NOMBRE+" TEXT)";

    //constantes campos tabla Mujer
    public static final String TABLA_MUJER="mujer";
    public static final String CAMPO_PK_MUJER="idMujer";
    public static final String CAMPO_MUJER_NOMBRE="situaciones";

    public static final String CREAR_TABLA_MUJER="CREATE TABLE "+TABLA_MUJER+" ("+CAMPO_PK_MUJER+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_MUJER_NOMBRE+" TEXT)";

    //constantes campos tabla Vacunas
    public static final String TABLA_VACUNAS="vacunas";
    public static final String CAMPO_PK_VACUNAS="idVacunas";
    public static final String CAMPO_VACUNAS_NOMBRE="nombre";

    public static final String CREAR_TABLA_VACUNAS="CREATE TABLE "+TABLA_VACUNAS+" ("+CAMPO_PK_VACUNAS+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_VACUNAS_NOMBRE+" TEXT)";

    //constantes campos tabla Seguro Publico
    public static final String TABLA_SEG_PUB="seguroPublico";
    public static final String CAMPO_PK_SEG_PUB="idSegPub";
    public static final String CAMPO_SEG_PUB_DIRECCION="direccion";
    public static final String CAMPO_SEG_PUB_INST_COMUN="instComun";

    public static final String CREAR_TABLA_SEG_PUB="CREATE TABLE "+TABLA_SEG_PUB+" ("+CAMPO_PK_SEG_PUB+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_SEG_PUB_DIRECCION+" TEXT, "+CAMPO_SEG_PUB_INST_COMUN+" TEXT)";

    //constantes campos tabla Seguro Privado
    public static final String TABLA_SEG_PRIV="seguroPrivado";
    public static final String CAMPO_PK_SEG_PRIV="idSegPriv";
    public static final String CAMPO_SEG_PRIV_DIRECCION="direccion";
    public static final String CAMPO_SEG_PRIV_ASEGURADORA="aseguradora";

    public static final String CREAR_TABLA_SEG_PRIV="CREATE TABLE "+TABLA_SEG_PRIV+" ("
            +CAMPO_PK_SEG_PRIV+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_SEG_PRIV_DIRECCION+" TEXT,"
            +CAMPO_SEG_PRIV_ASEGURADORA+" TEXT)";

    //constantes campos tabla Problemas Hereditarios
    public static final String TABLA_PROB_HER="probHereditarios";
    public static final String CAMPO_PK_PROB_HER="idProbHer";
    public static final String CAMPO_PROB_HER_NOMBRE="nombre";

    public static final String CREAR_TABLA_PROB_HER="CREATE TABLE "+TABLA_PROB_HER+" ("+CAMPO_PK_PROB_HER+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_PROB_HER_NOMBRE+" TEXT)";

    //constantes campos tabla Incidentes
    public static final String TABLA_INCIDENTES="incidentes";
    public static final String CAMPO_PK_INCIDENTES="idIncidentes";
    public static final String CAMPO_INCIDENTES_NOMBRE="nombre";

    public static final String CREAR_TABLA_INCIDENTES="CREATE TABLE "+TABLA_INCIDENTES+" ("+CAMPO_PK_INCIDENTES+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_INCIDENTES_NOMBRE+" TEXT)";

    //constantes campos tabla usuarios
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_CUM="cum";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APAT="aPat";
    public static final String CAMPO_AMAT="aMat";
    public static final String CAMPO_QR="QR";
    public static final String CAMPO_TIPO="tipo";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIO+" ("+CAMPO_CUM+
            " TEXT PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_APAT+" TEXT, "+CAMPO_AMAT+" TEXT, "+
            CAMPO_QR+" TEXT, "+CAMPO_TIPO+" INTEGER)";


    //constantes campos tabla informacion_Emergencia
    public static final String TABLA_INFO_EMERGENCIA="informacionEmergencia";
    public static final String CAMPO_INF_EMERGENCIA="pkInfoEmergencia";
    public static final String CAMPO_NOMB_CONT_EMERGENCIA="nombContacto";
    public static final String CAMPO_DIR_CONT_EMERGENCIA="dirContacto";
    public static final String CAMPO_TEL_CONT_EMERGENCIA="telContacto";

    public static final String CREAR_TABLA_INFO_EMERGENCIA="CREATE TABLE "+TABLA_INFO_EMERGENCIA+" ("+
            CAMPO_INF_EMERGENCIA+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMB_CONT_EMERGENCIA+" TEXT, "+
            CAMPO_DIR_CONT_EMERGENCIA+" TEXT, "+CAMPO_TEL_CONT_EMERGENCIA+" TEXT)";


    //constantes campos tabla Geolocalizacion
    public static final String TABLA_GEOLOCALIZACION="geolocalizacion";
    public static final String CAMPO_GEOLOCALIZACION="pkGeolocalizacion";
    public static final String CAMPO_LATITUD="latitud";
    public static final String CAMPO_LONGITUD="longitud";
    public static final String CAMPO_CONECTADO="conectado";

    public static final String CREAR_TABLA_GEOLOCALIZACION="CREATE TABLE "+TABLA_GEOLOCALIZACION+
            " ("+CAMPO_GEOLOCALIZACION+" TEXT PRIMARY KEY, "+CAMPO_LATITUD+" REAL, "+CAMPO_LONGITUD+
            " REAL, "+CAMPO_CONECTADO+" INTEGER)";

    //constantes campos tabla paciente
    public static final String TABLA_PACIENTE="paciente";
    public static final String CAMPO_PACIENTE_CUM="cum";
    public static final String CAMPO_PACIENTE_NOMBRE="nombre";
    public static final String CAMPO_PACIENTE_PATERNO="aPat";
    public static final String CAMPO_PACIENTE_MATERNO="aMat";
    public static final String CAMPO_PACIENTE_TIPO="tipo";
    public static final String CAMPO_PACIENTE_FK_USUARIO="fkUsuario";
    public static final String CAMPO_PACIENTE_FK_GEOLOCALIZACION="fkGeolocalizacion";
    public static final String CAMPO_PACIENTE_FK_INFO_EMERGENCIA="fkInfoEmergencia";

    public static final String CREAR_TABLA_PACIENTE="CREATE TABLE "+TABLA_PACIENTE+" ("+CAMPO_PACIENTE_CUM+
            " TEXT PRIMARY KEY, "+CAMPO_PACIENTE_NOMBRE+" TEXT, "+CAMPO_PACIENTE_PATERNO+" TEXT, "+
            CAMPO_PACIENTE_MATERNO+" TEXT, "+CAMPO_PACIENTE_TIPO+" INTEGER, "+CAMPO_PACIENTE_FK_USUARIO+
            " TEXT,"+CAMPO_PACIENTE_FK_GEOLOCALIZACION+" TEXT, "+CAMPO_PACIENTE_FK_INFO_EMERGENCIA+
            " INTEGER,FOREIGN KEY ("+CAMPO_PACIENTE_FK_USUARIO+") REFERENCES "+TABLA_USUARIO+"("+
            CAMPO_CUM+"), FOREIGN KEY ("+CAMPO_PACIENTE_FK_GEOLOCALIZACION+") REFERENCES "+TABLA_GEOLOCALIZACION+"("+
            CAMPO_GEOLOCALIZACION+"), FOREIGN KEY ("+CAMPO_PACIENTE_FK_INFO_EMERGENCIA+") REFERENCES "+
            TABLA_INFO_EMERGENCIA+"("+ CAMPO_INF_EMERGENCIA+"))";

    //constantes campos tabla amigos
    public static final String TABLA_AMIGOS="amigos";
    public static final String CAMPO_ID_AMIGOS="idAmigos";
    public static final String CAMPO_AMIGOS_NOMBRE="nombre";
    public static final String CAMPO_AMIGOS_PATERNO="aPat";
    public static final String CAMPO_AMIGOS_APODO="apodo";
    public static final String CAMPO_AMIGOS_FK_USUARIO="fkUsuario";

    public static final String CREAR_TABLA_AMIGOS="CREATE TABLE "+TABLA_AMIGOS+" ("+CAMPO_ID_AMIGOS+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_AMIGOS_NOMBRE+" TEXT, "+CAMPO_AMIGOS_PATERNO+" TEXT, "+
            CAMPO_AMIGOS_APODO+" TEXT, "+CAMPO_AMIGOS_FK_USUARIO+" TEXT, FOREIGN KEY ("+
            CAMPO_AMIGOS_FK_USUARIO+") REFERENCES "+TABLA_USUARIO+"("+CAMPO_CUM+"))";

    //constantes campos tabla lista
    public static final String TABLA_LISTA="lista";
    public static final String CAMPO_ID_LISTA="idLista";
    public static final String CAMPO_USER="user";
    public static final String CAMPO_FK_REDES="fkRedes";
    public static final String CAMPO_FK_AMIGOS="fkAmigos";

    public static final String CREAR_TABLA_LISTA="CREATE TABLE "+TABLA_LISTA+" ("+CAMPO_ID_LISTA+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_USER+" TEXT, "+CAMPO_FK_REDES+" INTEGER, "+CAMPO_FK_AMIGOS+
            " INTEGER, FOREIGN KEY ("+CAMPO_FK_REDES+") REFERENCES "+TABLA_REDES_SOCIALES+"("+CAMPO_PK_AMIGO+"))";

    //constantes campos tabla lentes
    public static final String TABLA_LENTES="lentes";
    public static final String CAMPO_ID_LENTES="idLentes";
    public static final String CAMPO_GRAD_DER="gradDer";
    public static final String CAMPO_GRAD_IZQ="gradIzq";
    public static final String CAMPO_L_FK_USUARIOS="fkUsuarios";

    public static final String CREAR_TABLA_LENTES="CREATE TABLE "+TABLA_LENTES+" ("+CAMPO_ID_LENTES+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_GRAD_DER+" REAL, "+CAMPO_GRAD_IZQ+" REAL, "+CAMPO_L_FK_USUARIOS+
            " TEXT, FOREIGN KEY("+CAMPO_L_FK_USUARIOS+") REFERENCES "+TABLA_USUARIO+"("+CAMPO_CUM+"))";

    //constantes campos tabla relacion Enfermedades inmunes
    public static final String TABLA_REL_ENF_INMUNES="relEnfInmunes";
    public static final String CAMPO_ID_ENF_INMUNES="idEnfInmunes";
    public static final String CAMPO_EI_FK_USUARIO="fkUsuario";
    public static final String CAMPO_FK_ENF_INMUNES="fkEnfInmunes";

    public static final String CREAR_TABLA_RELACION_ENF_INMUNES="CREATE TABLE "+TABLA_REL_ENF_INMUNES+
            " ("+CAMPO_ID_ENF_INMUNES+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_EI_FK_USUARIO+" TEXT, "+
            CAMPO_FK_ENF_INMUNES+" INTEGER, FOREIGN KEY("+CAMPO_EI_FK_USUARIO+") REFERENCES "+
            TABLA_USUARIO+"("+CAMPO_CUM+"),FOREIGN KEY("+CAMPO_FK_ENF_INMUNES+") REFERENCES "+
            TABLA_ENF_INMUNES+"("+CAMPO_PK_ENF_INMUNES+"))";

    //constantes campos tabla rel Alergias
    public static final String TABLA_REL_ALERGIAS="relAlergias";
    public static final String CAMPO_ID_ALERGIAS="idAlergias";
    public static final String CAMPO_A_FK_USUARIO="fkUsuario";
    public static final String CAMPO_FK_ALERGIAS="fkAlergias";

    public static final String CREAR_TABLA_RELACION_ALERGIAS="CREATE TABLE "+TABLA_REL_ALERGIAS+
            " ("+CAMPO_ID_ALERGIAS+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_A_FK_USUARIO+" TEXT, "+
            CAMPO_FK_ALERGIAS+" INTEGER, FOREIGN KEY ("+CAMPO_A_FK_USUARIO+") REFERENCES "+TABLA_USUARIO
            +"("+CAMPO_CUM+"), FOREIGN KEY ("+CAMPO_FK_ALERGIAS+") REFERENCES "+TABLA_ALERGIAS+"("+CAMPO_PK_ALERGIAS+"))";

    //constantes campos tabla rel problemas circulatorios
    public static final String TABLA_REL_PROB_CIRCULATORIOS="relProbCirculatorio";
    public static final String CAMPO_ID_PROB_CIRCULATORIOS="idProbCirculatorio";
    public static final String CAMPO_PC_FK_USUARIO="fkUsuario";
    public static final String CAMPO_FK_PROB_CIRCULATORIO="fkProbCirculatorio";

    public static final String CREAR_TABLA_RELACION_PROB_CIRCULATORIOS="CREATE TABLE "+TABLA_REL_PROB_CIRCULATORIOS+
            " ("+CAMPO_ID_PROB_CIRCULATORIOS+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_PC_FK_USUARIO+" TEXT, "+
            CAMPO_FK_PROB_CIRCULATORIO+" INTEGER, FOREIGN KEY ("+CAMPO_PC_FK_USUARIO+") REFERENCES "+TABLA_USUARIO
            +"("+CAMPO_CUM+"), FOREIGN KEY ("+CAMPO_FK_PROB_CIRCULATORIO+") REFERENCES "+
            TABLA_PROB_CIRCULATORIOS+"("+CAMPO_PK_PROB_CIRCULATORIOS+"))";

    //constantes campos tabla rel fracturas
    public static final String TABLA_REL_FRACTURAS="relFracturas";
    public static final String CAMPO_ID_FRACTURAS="idFracturas";
    public static final String CAMPO_F_FK_USUARIO="fkUsuario";
    public static final String CAMPO_FK_FRACTURAS="fkFracturas";

    public static final String CREAR_TABLA_RELACION_FRACTURAS="CREATE TABLE "+TABLA_REL_FRACTURAS+
            " ("+CAMPO_ID_FRACTURAS+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_F_FK_USUARIO+" TEXT, "+
            CAMPO_FK_FRACTURAS+" INTEGER, FOREIGN KEY ("+CAMPO_F_FK_USUARIO+") REFERENCES "+TABLA_USUARIO
            +"("+CAMPO_CUM+"), FOREIGN KEY ("+CAMPO_FK_FRACTURAS+") REFERENCES "+TABLA_FRACTURAS+"("+
            CAMPO_PK_FRACTURAS+"))";

    //constantes campos tabla rel cirugias
    public static final String TABLA_REL_CIRUGIAS="relCirugias";
    public static final String CAMPO_ID_CIRUGIAS="idCirugias";
    public static final String CAMPO_FECHA_CIRUGIAS="fechaCirugias";
    public static final String CAMPO_C_FK_USUARIO="fkUsuario";
    public static final String CAMPO_FK_CIRUGIAS="fkCirugias";

    public static final String CREAR_TABLA_RELACION_CIRUGIAS="CREATE TABLE "+TABLA_REL_CIRUGIAS+" ("+
            CAMPO_ID_CIRUGIAS+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_FECHA_CIRUGIAS+" TEXT, "+CAMPO_C_FK_USUARIO+
            " TEXT, "+CAMPO_FK_CIRUGIAS+" INTEGER, FOREIGN KEY ("+CAMPO_C_FK_USUARIO+") REFERENCES "+TABLA_USUARIO
            +"("+CAMPO_CUM+"), FOREIGN KEY ("+CAMPO_FK_CIRUGIAS+") REFERENCES "+TABLA_CIRUGIAS+"("+CAMPO_PK_CIRUGIAS+"))";

    //constantes campos tabla rel Enfermedades
    public static final String TABLA_REL_ENFERMEDADES="relEnfermedades";
    public static final String CAMPO_ID_ENFERMEDADES="idEnfermedades";
    public static final String CAMPO_FECHA_ENFERMEDADES="fechaEnfermedades";
    public static final String CAMPO_E_FK_USUARIO="fkUsuario";
    public static final String CAMPO_FK_ENFERMEDADES="fkEnfermedades";

    public static final String CREAR_TABLA_RELACION_ENFERMEDADES="CREATE TABLE "+TABLA_REL_ENFERMEDADES+
            " ("+CAMPO_ID_ENFERMEDADES+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_FECHA_ENFERMEDADES+" TEXT, "+
            CAMPO_E_FK_USUARIO+" TEXT, "+CAMPO_FK_ENFERMEDADES+" INTEGER, FOREIGN KEY ("+
            CAMPO_E_FK_USUARIO+") REFERENCES "+TABLA_USUARIO +"("+CAMPO_CUM+"), FOREIGN KEY ("+
            CAMPO_FK_ENFERMEDADES+") REFERENCES "+TABLA_ENFERMEDADES+"("+CAMPO_PK_ENFERMEDADES+")";

    //constantes campos tabla rel Mujer
    public static final String TABLA_REL_MUJER="relMujer";
    public static final String CAMPO_ID_MUJER="idMujer";
    public static final String CAMPO_M_FK_USUARIO="fkUsuario";
    public static final String CAMPO_FK_MUJER="fkMujer";

    public static final String CREAR_TABLA_RELACION_MUJER="CREATE TABLE "+TABLA_REL_MUJER+
            " ("+CAMPO_ID_MUJER+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_M_FK_USUARIO+" TEXT, "+
            CAMPO_FK_MUJER+" INTEGER, FOREIGN KEY ("+CAMPO_M_FK_USUARIO+") REFERENCES "+TABLA_USUARIO
            +"("+CAMPO_CUM+"), FOREIGN KEY ("+CAMPO_FK_MUJER+") REFERENCES "+TABLA_MUJER+"("+
            CAMPO_PK_MUJER+"))";

    //constantes campos tabla rel vacunas
    public static final String TABLA_REL_VACUNAS="relVacunas";
    public static final String CAMPO_ID_VACUNAS="idVacunas";
    public static final String CAMPO_FECHA_VACUNAS="fechaVacunas";
    public static final String CAMPO_V_FK_USUARIO="fkUsuario";
    public static final String CAMPO_FK_VACUNAS="fkVacunas";

    public static final String CREAR_TABLA_RELACION_VACUNAS="CREATE TABLE "+TABLA_REL_VACUNAS+" ("+
            CAMPO_ID_VACUNAS+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_FECHA_VACUNAS+" TEXT, "+CAMPO_V_FK_USUARIO+
            " TEXT, "+CAMPO_FK_VACUNAS+" INTEGER, FOREIGN KEY ("+CAMPO_V_FK_USUARIO+") REFERENCES "+TABLA_USUARIO
            +"("+CAMPO_CUM+"), FOREIGN KEY ("+CAMPO_FK_VACUNAS+") REFERENCES "+TABLA_VACUNAS+"("+
            CAMPO_PK_VACUNAS+"))";

    //constantes campos tabla rel Seg Publica
    public static final String TABLA_REL_SEG_PUBLICA="relSegPublica";
    public static final String CAMPO_ID_SEG_PUBLICA="idSegPublica";
    public static final String CAMPO_POLIZA_SEG_PUBLICA="polizaSegPublica";
    public static final String CAMPO_SP_FK_USUARIO="fkUsuario";
    public static final String CAMPO_FK_SEG_PUBLICA="fkSegPublica";

    public static final String CREAR_TABLA_RELACION_SEG_PUBLICA="CREATE TABLE "+TABLA_REL_SEG_PUBLICA+
            " ("+CAMPO_ID_SEG_PUBLICA+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_POLIZA_SEG_PUBLICA+" TEXT, "+
            CAMPO_SP_FK_USUARIO+" TEXT, "+CAMPO_FK_SEG_PUBLICA+" INTEGER, FOREIGN KEY ("+
            CAMPO_SP_FK_USUARIO+") REFERENCES "+TABLA_USUARIO +"("+CAMPO_CUM+"), FOREIGN KEY ("+
            CAMPO_FK_SEG_PUBLICA+") REFERENCES "+TABLA_REL_SEG_PUBLICA+"("+ CAMPO_PK_SEG_PUB+"))";

    //constantes campos tabla rel Seg Privada
    public static final String TABLA_REL_SEG_PRIVADA="relSegPrivada";
    public static final String CAMPO_ID_SEG_PRIVADA="idSegPrivada";
    public static final String CAMPO_POLIZA_SEG_PRIVADA="polizaSegPrivada";
    public static final String CAMPO_TIPO_SEG_PRIVADA="tipoSegPrivada";
    public static final String CAMPO_SPR_FK_USUARIO="fkUsuario";
    public static final String CAMPO_FK_SEG_PRIVADA="fkSegPrivada";

    public static final String CREAR_TABLA_RELACION_SEG_PRIVADA="CREATE TABLE "+TABLA_REL_SEG_PRIVADA+
            " ("+CAMPO_ID_SEG_PRIVADA+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_POLIZA_SEG_PRIVADA+" TEXT, "+
            CAMPO_TIPO_SEG_PRIVADA+" INTEGER, "+CAMPO_SPR_FK_USUARIO+" TEXT, "+CAMPO_FK_SEG_PRIVADA+
            " INTEGER, FOREIGN KEY ("+CAMPO_SPR_FK_USUARIO+") REFERENCES "+TABLA_USUARIO
            +"("+CAMPO_CUM+"), FOREIGN KEY ("+CAMPO_FK_SEG_PRIVADA+") REFERENCES "+TABLA_SEG_PRIV+"("+
            CAMPO_PK_SEG_PRIV+"))";

    //constantes campos tabla rel Prob Hereditarios
    public static final String TABLA_REL_PROB_HER="relProbHer";
    public static final String CAMPO_ID_PROB_HER="idProbHer";
    public static final String CAMPO_PH_FK_USUARIO="fkUsuario";
    public static final String CAMPO_FK_PROB_HER="fkProbHer";

    public static final String CREAR_TABLA_RELACION_PROB_HER="CREATE TABLE "+TABLA_REL_PROB_HER+
            " ("+CAMPO_ID_PROB_HER+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_PH_FK_USUARIO+" TEXT, "+
            CAMPO_FK_PROB_HER+" INTEGER, FOREIGN KEY ("+CAMPO_PH_FK_USUARIO+") REFERENCES "+TABLA_USUARIO
            +"("+CAMPO_CUM+"), FOREIGN KEY ("+CAMPO_FK_PROB_HER+") REFERENCES "+TABLA_PROB_HER+"("+
            CAMPO_PK_PROB_HER+"))";

    //constantes campos tabla rel incidentes
    public static final String TABLA_REL_INCIDENTES="relIncidentes";
    public static final String CAMPO_ID_INCIDENTES="idIncidentes";
    public static final String CAMPO_TITULO_INCIDENTES="tituloIncidentes";
    public static final String CAMPO_DESCRIPCION_INCIDENTES="descripcionIncidentes";
    public static final String CAMPO_HORA_INCIDENTES="horaIncidentes";
    public static final String CAMPO_I_FK_USUARIO="fkUsuario";
    public static final String CAMPO_FK_INCIDENTES="fkIncidentes";

    public static final String CREAR_TABLA_RELACION_INCIDENTES="CREATE TABLE "+TABLA_REL_INCIDENTES+
            " ("+CAMPO_ID_INCIDENTES+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_TITULO_INCIDENTES+" TEXT, "+
            CAMPO_DESCRIPCION_INCIDENTES+" TEXT, "+CAMPO_HORA_INCIDENTES+" TEXT, "+CAMPO_I_FK_USUARIO+
            " TEXT, "+CAMPO_FK_INCIDENTES+" INTEGER, FOREIGN KEY ("+CAMPO_I_FK_USUARIO+") REFERENCES "+TABLA_USUARIO
            +"("+CAMPO_CUM+"), FOREIGN KEY ("+CAMPO_FK_INCIDENTES+") REFERENCES "+TABLA_INCIDENTES+"("+
            CAMPO_PK_INCIDENTES+"))";



    //constantes campos tabla Actividades
    public static final String TABLA_ACTIVIDADES="actividades";
    public static final String CAMPO_PK_ACTIVIDADES="idAct";
    public static final String CAMPO_LAT_ACTIVIDADES="latAct";
    public static final String CAMPO_LONG_ACTIVIDADES="longAct";
    public static final String CAMPO_NOMBRE_ACTIVIDADES="nombreAct";
    public static final String CAMPO_DESCRIPCION_ACTIVIDADES="descAct";
    public static final String CAMPO_HORA_INICIO_ACTIVIDADES="horaInicioAct";
    public static final String CAMPO_ACT_FK_USUARIO="fkUsuario";

    public static final String CREAR_TABLA_ACTIVIDADES="CREATE TABLE "+TABLA_ACTIVIDADES+" ("+
            CAMPO_PK_ACTIVIDADES+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_LAT_ACTIVIDADES+" REAL, "+
            CAMPO_LONG_ACTIVIDADES+" REAL, "+CAMPO_NOMBRE_ACTIVIDADES+" TEXT, "+
            CAMPO_DESCRIPCION_ACTIVIDADES+" TEXT, "+CAMPO_HORA_INICIO_ACTIVIDADES+" TEXT, "+
            CAMPO_ACT_FK_USUARIO+" TEXT, FOREIGN KEY ("+CAMPO_ACT_FK_USUARIO+") REFERENCES "+TABLA_USUARIO
            +"("+CAMPO_CUM+"))";


    public static final String CREAR_SISTEMA="";
}
