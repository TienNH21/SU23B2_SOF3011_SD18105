package controllers;

import entities.CuaHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.CuaHangRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet({
    "/cua-hang/index",      // GET
    "/cua-hang/create",     // GET
    "/cua-hang/store",      // POST
    "/cua-hang/edit",       // GET
    "/cua-hang/update",     // POST
    "/cua-hang/delete",     // GET
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository chRepo;

    public CuaHangServlet() {
        this.chRepo = new CuaHangRepository();
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
        String ma = request.getParameter("ma");
        CuaHang ch = this.chRepo.findByMa(ma);
        request.setAttribute("data", ch);
        request.getRequestDispatcher("/views/cua_hang/edit.jsp")
            .forward(request, response);
    }

    public void delete(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        CuaHang ch = this.chRepo.findByMa(ma);
        this.chRepo.delete(ch);
        response.sendRedirect("/SU23B2_SOF3011_SD18105_war_exploded/cua-hang/index");
    }

    public void index(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        request.setAttribute("list", this.chRepo.findAll());
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
        String ma = request.getParameter("ma");
        CuaHang oldValue = this.chRepo.findByMa(ma);
        oldValue.setTen(request.getParameter("ten"));
        oldValue.setDiaChi(request.getParameter("diaChi"));
        oldValue.setThanhPho(request.getParameter("thanhPho"));
        oldValue.setQuocGia(request.getParameter("quocGia"));
        this.chRepo.update(oldValue);

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

        CuaHang ch = new CuaHang(null, ma, ten, diaChi, thanhPho, quocGia);
        this.chRepo.insert(ch);
        response.sendRedirect("/SU23B2_SOF3011_SD18105_war_exploded/cua-hang/index");
    }

}
