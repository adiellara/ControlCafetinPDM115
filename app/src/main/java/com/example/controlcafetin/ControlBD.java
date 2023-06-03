package com.example.controlcafetin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControlBD {

    private static final String[]camposLocal = new String []
            {"dui","nombre","apellido","sexo", "idsucursal"};
    private static final String[]camposPreciou = new String []
            {"dui","codproducto","local","cuentafinal"};
    private static final String[] camposProductos = new String []
            {"codproducto","nomproducto","precio"};
    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    public ControlBD(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
        
    }

    public String llenarBD() {
        return null;
    }


    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "Local.s3db";
        private static final int VERSION = 1;
        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL("CREATE TABLE Local(dui VARCHAR(7) NOT NULL PRIMARY KEY,nombre VARCHAR(30),apellido VARCHAR(30),sexo VARCHAR(1),idsucursal INTEGER);");
                db.execSQL("CREATE TABLE productos(codproducto VARCHAR(6) NOT NULL PRIMARY KEY,nomproducto VARCHAR(30),precio VARCHAR(1));");
                db.execSQL("CREATE TABLE preciou(dui VARCHAR(7) NOT NULL ,codproducto VARCHAR(6) NOT NULL ,local VARCHAR(5) ,cuentafinal REAL ,PRIMARY KEY(dui,codproducto,local));");
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        }
    }
    public void abrir() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return;
    }
    public void cerrar(){
        DBHelper.close();
    }

    public String insertar(Preciou preciou){
    
        return null;
    }
    public String actualizar(Productos productos){
        return null;
    }
    public String actualizar(Preciou preciou){
        return null;
    }
    public String eliminar(Preciou preciou){
        return null;
    }
    public Local consultarLocal(String dui){
        return null;
    }
    public Productos consultarProductos(String codproducto){
        return null;
    }
    public Preciou consultarPreciou(String dui, String codproducto, String local){
        return null;
    }
    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch(relacion){
    
            case 1:
            {
//verificar que al insertar preciou exista dui del Local y el codigo de productos
                Preciou preciou = (Preciou)dato;
                String[] id1 = {preciou.getdui()};
                String[] id2 = {preciou.getCodproducto()};
//abrir();
                Cursor cursor1 = db.query("Local", null, "dui = ?", id1, null,
                        null, null);
                Cursor cursor2 = db.query("productos", null, "codproducto = ?", id2,
                        null, null, null);
                if(cursor1.moveToFirst() && cursor2.moveToFirst()){
//Se encontraron datos
                    return true;
                }
                return false;
            }
            case 2:
            {
//verificar que al modificar preciou exista dui del Local, el codigo de productos y el local
                Preciou preciou1 = (Preciou)dato;
                String[] ids = {preciou1.getdui(), preciou1.getCodproducto(),
                        preciou1.getLocal()};
                abrir();
                Cursor c = db.query("preciou", null, "dui = ? AND codproducto = ? AND local = ?", ids, null, null, null);
                if(c.moveToFirst()){
//Se encontraron datos
                    return true;
                }
                return false;
            }
            case 3:
            {
                Local Local = (Local)dato;
                Cursor c=db.query(true, "preciou", new String[] {
                                "dui" }, "dui='"+Local.getdui()+"'",null,
                        null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 4:
            {
                Productos productos = (Productos)dato;
                Cursor cmat=db.query(true, "preciou", new String[] {
                                "codproducto" },
                        "codproducto='"+productos.getCodproducto()+"'",null, null, null, null, null);
                if(cmat.moveToFirst())
                 
                return true;
else
                return false;
            }
            case 5:
            {
//verificar que exista Local
                Local Local2 = (Local)dato;
                String[] id = {Local2.getdui()};
                abrir();
                Cursor c2 = db.query("Local", null, "dui = ?", id, null, null,
                        null);
                if(c2.moveToFirst()){
//Se encontro Local
                    return true;
                }
                return false;
            }
            case 6:
            {
//verificar que exista Productos
                Productos productos2 = (Productos)dato;
                String[] idm = {productos2.getCodproducto()};
                abrir();
                Cursor cm = db.query("productos", null, "codproducto = ?", idm, null,
                        null, null);
                if(cm.moveToFirst()){
//Se encontro Productos
                    return true;
                }
                return false;
            }
            default:
                return false;
        }
    }
    public String llenarBDdui(){
        final String[] VAdui = {"1212035","1212044","2111098","1212021"};
        final String[] VAnombre = {"Carlos","Gabriela","Pedro","Sara"};
        final String[] VAapellido = {"Orantes","Ortiz","Gonzales","Coto"};
        final String[] VAsexo = {"M","F","M","F"};
        final String[] VMcodproducto = {"SAN001","TOR001","PLA001","JUG001"};
        final String[] VMnomproducto = {"Sanwich I","Torta de jamon I","Platano","Jugo de naranja"};
        final String[] VMprecio = {"1","2","1","2"};
        final String[] VNdui =
                {"OO12035","OF12044","GG11098","CC12021","OO12035","GG11098","OF12044"};
        final String[] VNcodproducto =
                {"SAN001","TOR001","PLA001","JUG001","IC115","SAN001","TOR001"};
        final String[] VNlocal =
                {"12016","12016","22016","22016","22016","12016","22016"};
        final float[] VNcuentafinal = {7,5,8,7,6,10,7};
        abrir();
        db.execSQL("DELETE FROM Local");
        db.execSQL("DELETE FROM productos");
        db.execSQL("DELETE FROM preciou");
        Local Local = new Local();
        for(int i=0;i<4;i++){
            Local.setdui(VAdui[i]);
            Local.setNombre(VAnombre[i]);
            Local.setApellido(VAapellido[i]);
            Local.setSexo(VAsexo[i]);
            Local.setidsucursal(0);
            insertar(Local);
        }
        Productos productos = new Productos();
        for(int i=0;i<4;i++){
            productos.setCodproducto(VMcodproducto[i]);
            productos.setNomproducto(VMnomproducto[i]);
            productos.setPrecio(VMprecio[i]);
            insertar(productos);
        }
        Preciou preciou = new Preciou();
        for(int i=0;i<7;i++){
            preciou.setdui(VNdui[i]);
            preciou.setCodproducto(VNcodproducto[i]);
            preciou.setLocal(VNlocal[i]);
            preciou.setCuentafinal(VNcuentafinal[i]);
            insertar(preciou);
        }
        cerrar();
        return "Guardo Correctamente";
}

    public String insertar(Local local){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues loc = new ContentValues();
        loc.put("dui", local.getdui());
        loc.put("nombre", local.getNombre());
        loc.put("apellido", local.getApellido());
        loc.put("sexo", local.getSexo());
        loc.put("sucursal", local.getidsucursal());
        contador=db.insert("local", null, loc);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public Local consultarLocal(int dui){
        String[] id = {String.valueOf(dui)};
        Cursor cursor = db.query("local", camposLocal, "dui = ?",
                id, null, null, null);
        if(cursor.moveToFirst()){
            Local local = new Local();
            local.setDui(cursor.getString(0));
            local.setNombre(cursor.getString(1));
            local.setApellido(cursor.getString(2));
            local.setSexo(cursor.getString(3));
            local.setidlocal(cursor.getInt(4));
            return local;
        }else{
            return null;
        }
    }
    public String actualizar(Local local){
        if(verificarIntegridad(local, 5)){
            String[] id = {local.getdui()};
            ContentValues cv = new ContentValues();
            cv.put("nombre", local.getNombre());
            cv.put("apellido", local.getApellido());
            cv.put("sexo", local.getSexo());
            db.update("local", cv, "dui = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con dui " + local.getdui() + " no existe";
        }
    }
    public String eliminar(Local local){
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(local,3)) {
            contador+=db.delete("Pedido", "dui='"+local.getdui()+"'", null);
        }
        contador+=db.delete("local", "dui='"+local.getdui()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }
    public String insertar(Productos productos){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues mate = new ContentValues();
        mate.put("codproductos", productos.getCodproducto());
        mate.put("nomproductos", productos.getCodproducto());
        mate.put("unidadesval", productos.getUnidadesval());
        contador=db.insert("productos", null, mate);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String insertar(Pedido pedido) {
        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;
        if (verificarIntegridad(pedido, 1)) {
            ContentValues pedidoss = new ContentValues();
            pedidoss.put("dui", pedido.getdui());
            pedidoss.put("codproducto", pedido.getCodproducto());
            pedidoss.put("local", pedido.getlocal());
            pedidoss.put("cuentafinal", pedido.getcuentafinal());
            contador = db.insert("pedido", null, pedidoss);
        }
        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro Duplicado.Verificar inserción ";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }
    }