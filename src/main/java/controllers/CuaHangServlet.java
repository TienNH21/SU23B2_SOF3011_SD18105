package controllers;

import entities.CuaHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
    "/cua-hang/index",      // GET
    "/cua-hang/create",     // GET
    "/cua-hang/store",      // POST
    "/cua-hang/edit",       // GET
    "/cua-hang/update",     // POST
    "/cua-hang/delete",     // GET
})
public class CuaHangServlet extends HttpServlet {
    private ArrayList<CuaHang> list;

    public CuaHangServlet() {
        this.list = new ArrayList<>();
        this.list.add(new CuaHang(1, "CH1", "Cua Hang TVB", "TVB", "HN", "VN"));
        this.list.add(new CuaHang(2, "CH2", "Cua Hang TVB", "TVB", "HN", "VN"));
        this.list.add(new CuaHang(3, "CH3", "Cua Hang TVB", "TVB", "HN", "VN"));
    }

    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }


    public void edit(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        for (int i = 0; i < this.list.size(); i++) {
            CuaHang ch = this.list.get(i);
            if (ch.getId() == id) {
                request.setAttribute("data", ch);
            }
        }

        request.getRequestDispatcher("/views/cua_hang/edit.jsp")
            .forward(request, response);
    }

    public void delete(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        for (int i = 0; i < this.list.size(); i++) {
            CuaHang ch = this.list.get(i);
            if (ch.getId() == id) {
                this.list.remove(i);
            }
        }

        response.sendRedirect("/SU23B2_SOF3011_SD18105_war_exploded/cua-hang/index");
    }

    public void index(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        request.setAttribute("list", this.list);
        request.getRequestDispatcher("/views/cua_hang/index.jsp")
            .forward(request, response);
    }

    public void create(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        request.getRequestDispatcher("/views/cua_hang/create.jsp")
            .forward(request, response);
    }

    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }

    public void update(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("ten");
        String ma = request.getParameter("ma");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        CuaHang ch = new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia);
        for (int i = 0; i < this.list.size(); i++) {
            CuaHang ch1 = this.list.get(i);
            if (ch1.getId() == id) {
                this.list.set(i, ch);
            }
        }

        response.sendRedirect("/SU23B2_SOF3011_SD18105_war_exploded/cua-hang/index");
    }

    public void store(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        String ma = request.getParameter("ma");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        CuaHang ch = new CuaHang(1, ma, ten, diaChi, thanhPho, quocGia);
        this.list.add(ch);
        response.sendRedirect("/SU23B2_SOF3011_SD18105_war_exploded/cua-hang/index");
    }

}
