package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("toFile")
    public String toFile(HttpServletRequest request, Model model) { //参数中传入Model
        return "file/file";
    }

    @RequestMapping("toDownload")
    public String toDownload(HttpServletRequest request, Model model) { //参数中传入Model
        return "file/download";
    }

    @RequestMapping("toUpload")
    public String toUpload(HttpServletRequest request, Model model) { //参数中传入Model
        return "file/upload";
    }

    @RequestMapping("toInput")
    public String toInput(HttpServletRequest request, Model model) { //参数中传入Model
        return "file/input";
    }

    @RequestMapping("toOutput")
    public String toOutput(HttpServletRequest request, Model model) { //参数中传入Model
        return "file/output";
    }

    @RequestMapping("toReader")
    public String toReader(HttpServletRequest request, Model model) { //参数中传入Model
        return "file/reader";
    }

    @RequestMapping("toWriter")
    public String toWriter(HttpServletRequest request, Model model) { //参数中传入Model
        return "file/writer";
    }

    @RequestMapping("toRandom")
    public String toRandom(HttpServletRequest request, Model model) { //参数中传入Model
        return "file/random";
    }
}