package PDF;

import java.io.File;

public class PDFTest {

	public static void main(String[] args) throws Exception {
		
		User user = new User();
        
		user.setName("张三");
		user.setAge("20");
		user.setCode("10086");
		user.setHeight("180cm");
       
        PDFTemplet pdfT = new PDFTemplet();
       
        pdfT.setTemplatePdfPath("D:\\demo.pdf");
        pdfT.setTargetPdfpath("D:\\aaabbbccc.pdf");
        pdfT.setUser(user);
       
        File file = new File("D:\\aaabbbccc.pdf");
        Long startTime = System.currentTimeMillis();
        file.createNewFile();
        pdfT.templetTicket(file);
        System.out.println("消耗时间:"+(System.currentTimeMillis()-startTime));
       
        //OSSConfigureconfig = OSSUtil.getOSSConfigure();
        //OSSManageUtil.uploadFile(config, file, "aaabbbccc.pdf","pdf", "ticket/" + "aaabbbccc");

        //System.out.println("path = " + config.getAccessUrl());
	}

}
