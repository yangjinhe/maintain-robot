package com.yjh;

import org.nutz.mvc.NutFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by yangjh on 2017/9/17.
 */
@WebFilter(initParams =
        {@WebInitParam(name = "modules", value = "com.yjh.MainModule")},
        urlPatterns = "/*")
public class ApplicationFilter extends NutFilter {

}
