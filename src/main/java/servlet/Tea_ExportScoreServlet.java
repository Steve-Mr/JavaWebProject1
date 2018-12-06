package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import vo.Score;
import vo.Student;
import vo.Teacher;

import dao.ScoreDAO;
import dao.StudentDAO;
import dao.TeacherDAO;

public class Tea_ExportScoreServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String courseno = request.getParameter("courseno");//所选课程的课程号
        ScoreDAO sdao = new ScoreDAO();
        Score sco = null;

        try{
            ArrayList scores = sdao.getScoreByCourseno(courseno);
            if(scores.size()!=0){
                Document doc = new Document();//默认为A4页面
                String path = request.getRealPath("/res/reports");
                PdfWriter pw =
                        PdfWriter.getInstance(doc,new java.io.FileOutputStream(path + "/report.pdf"));
                doc.open();
                Table  t = new Table(5,5);
                t.setDefaultHorizontalAlignment(Table.ALIGN_CENTER);
                t.setPadding(4);//边框和文字的距离
                String prefixFont = "";
                String os = System.getProperties().getProperty("os.name");
                if (os.startsWith("win") || os.startsWith("Win")) {
                    prefixFont = "C:\\Windows\\Fonts" + File.separator;
                } else {
                    prefixFont = "/usr/share/fonts" + File.separator;
                }
                BaseFont baseFont = BaseFont.createFont(prefixFont+"/msyh.ttf",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
                Font font = new Font(baseFont,10);//10表示字体大小
                for(int i=0;i<scores.size();i++){
                    sco = (Score)scores.get(i);
                    t.addCell(new Phrase(sco.getCourseno(),font));
                    t.addCell(new Phrase(sco.getCoursename(),font));
                    t.addCell(new Phrase(sco.getStuno(),font));
                    t.addCell(new Phrase(sco.getStuname(),font));
                    if(sco.getScore()==0){	t.addCell(new Phrase("未登分",font));}
                    else{	t.addCell(new Phrase(""+sco.getScore(),font));}
                }
                doc.add(t);
                doc.close();
                response.setHeader("Content-Disposition","attachment;filename=report.pdf");//出现下载框
            }
            request.getRequestDispatcher("/res/reports/report.pdf").forward(request, response);
        }catch(Exception ex){	ex.printStackTrace();}
    }

}