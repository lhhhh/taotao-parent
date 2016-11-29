package PDF;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
 
public class PDFTemplet {
 
         private String templatePdfPath;
         private String ttcPath;
         private String targetPdfpath;
         private User user;
        
        
         public PDFTemplet() {
               super();
         }
        
         public PDFTemplet(String templatePdfPath, String ttcPath, String targetPdfpath, User user) {
               this.templatePdfPath= templatePdfPath;
               this.ttcPath= ttcPath;
               this.targetPdfpath= targetPdfpath;
               this.user= user;
         }
        
         public void templetTicket(File file) throws Exception {
                  
               PdfReader reader = new PdfReader(templatePdfPath);
               ByteArrayOutputStream bos = new ByteArrayOutputStream();
               PdfStamper ps = new PdfStamper(reader, bos);
              
               /*使用中文字体 */ 
               BaseFont bf = BaseFont.createFont(User.class.getResource("/") +"PDF/simsun.ttc,1", 
            		   								 BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
               ArrayList<BaseFont> fontList = new ArrayList<BaseFont>(); 
               fontList.add(bf); 
                  
               AcroFields s = ps.getAcroFields();
               s.setSubstitutionFonts(fontList);
 
               s.setField("name",user.getName());
               s.setField("code",user.getCode());
               s.setField("age",user.getAge());
               s.setField("height",user.getHeight());
              
               ps.setFormFlattening(true);
               ps.close();
              
               FileOutputStream fos = new FileOutputStream(file);
               fos.write(bos.toByteArray());
               fos.close();
         }
 
         public String getTemplatePdfPath() {
               return templatePdfPath;
         }
 
         public void setTemplatePdfPath(String templatePdfPath) {
               this.templatePdfPath= templatePdfPath;
         }
 
         public String getTtcPath() {
               return this.ttcPath;
         }
 
         public void setTtcPath(String ttcPath) {
               this.ttcPath= ttcPath;
         }
 
         public String getTargetPdfpath() {
               return targetPdfpath;
         }
 
         public void setTargetPdfpath(String targetPdfpath) {
               this.targetPdfpath= targetPdfpath;
         }
 
         public User getUser() {
               return user;
         }
 
         public void setUser(User user) {
               this.user= user;
         }
}