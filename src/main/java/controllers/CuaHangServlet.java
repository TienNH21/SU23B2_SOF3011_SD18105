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
    }

    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            // edit.jsp
        } else if (uri.contains("delete")) {
            // delete
        } else {
            // index.jsp
            this.index(request, response);
        }
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
            // edit.jsp
        }
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
    }
}
