/**
 * FileName:         ExcelController.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年10月18日     下午3:55:37
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年10月18日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.shiro.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwc.shiro.entity.User;
import com.zwc.shiro.service.UserService;
import com.zwc.shiro.utils.ExcelUtil;

/**
 * @ClassName:       ExcelController
 * @author:          zhuWeichao
 * @date:            2018年10月18日        下午3:55:37
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<User> users = userService.getList();
		System.err.println(users.size());
		
		
		//excel标题
		String[] title = {"ID","姓名","密码","角色"};
		
		String [][] content = new String[users.size()][];
		//excel文件名
		String fileName = "用户信息表"+System.currentTimeMillis()+".xls";
		String sheetName = "用户信息表";
		for (int i = 0; i < users.size(); i++) {
			content[i] = new String[title.length];
			User user = users.get(i);
			content[i][0] = user.getId().toString();
			content[i][1] = user.getUsername();
			content[i][2] = user.getPassword();
			content[i][3] = user.getRoleId().toString();
		}
		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
		try {
			this.setResponseHeader(response, fileName);
	        OutputStream os = response.getOutputStream();
	        wb.write(os);
	        os.flush();
	        os.close();
		} catch (Exception e) {
	       e.printStackTrace();
	    }
	}
	public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
