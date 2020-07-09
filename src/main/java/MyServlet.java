import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/test")
public class MyServlet extends HttpServlet {

    ItemService itemService = new ItemService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.getWriter().println(itemService.findById(Long.valueOf(req.getParameter("id"))).toString());
        }catch (Exception e){
            resp.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item = mapper(req);
        try {
            resp.getWriter().println(itemService.save(item));
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item = mapper(req);
        try {
            resp.getWriter().println(itemService.update(item));
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            itemService.delete(Long.parseLong(req.getParameter("id")));
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    private Item mapper(HttpServletRequest req)throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } finally {
            reader.close();
        }
        String data = sb.toString();

        ObjectMapper mapper = new ObjectMapper();
        Item item = mapper.readValue(data, Item.class);
        return item;
    }
}
