public class CircularImage{

    public static Bitmap getCroppedBitmap(Bitmap bmp) {
        Bitmap sbmp;
        
        sbmp = cropMenorAresta(bmp);
        
        // Nova Imagem...
        Bitmap output = Bitmap.createBitmap(sbmp.getWidth(), sbmp.getHeight(), Config.ARGB_8888);
        
        // Canvas onde iremos desenhar
        Canvas canvas = new Canvas(output);
        
        //  Configuramos o Paint...
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, sbmp.getWidth(), sbmp.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawCircle(sbmp.getWidth() / 2 + 0.7f,  sbmp.getHeight() / 2 + 0.7f, sbmp.getWidth() / 2 + 0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);
        
        return output;
    }
    
    private Bitmap cropMenorAresta(Bitmap bitmap){
       // ajusta imagem retangular à menor aresta
       int scale = ( bitmap.getWidth() > bitmap.getHeight() ) ? bitmap.getHeight() : bitmap.getWidth();
       return Bitmap.createScaledBitmap(bitmap, scale, scale, false);
    }
    
}
