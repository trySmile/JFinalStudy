package cn.jfinal.config;


import cn.jfinal.controller.AllController;
import cn.jfinal.pojo.User;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class MainConfig extends JFinalConfig {

    public void configConstant(Constants constants) {
        // 设置视图类型
        constants.setViewType(ViewType.JSP);
        // 设置开发模式
        constants.setDevMode(true);
    }
    // 配置路由
    public void configRoute(Routes routes) {
        routes.add("/", AllController.class);
        System.out.println("加载映射器完成  --- > /");
    }

    public void configEngine(Engine engine) {

    }

    public void configPlugin(Plugins plugins) {
        // 配置插件  mysql
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost/ssmpor","root","root");
        plugins.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        plugins.add(arp);
        arp.addMapping("user","username", User.class);
    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }
    public static void main(String[] args){
        JFinal.start("src/main/webapp",80,"/",5);
    }
}
