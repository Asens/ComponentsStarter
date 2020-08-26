package cn.asens.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author Asens
 * create 2019-06-11 8:25
 **/

@WebServlet(
        urlPatterns = {"/druid/*"},
        initParams = {
                @WebInitParam(name = "loginUsername", value = "admin"),
                @WebInitParam(name = "loginPassword", value = "test"),
                @WebInitParam(name = "resetEnable", value = "false")
//      @WebInitParam(name = "allow", value = "127.0.0.1")
        }
)
public class DruidStatViewServlet extends StatViewServlet {
}
