package com.yjh;

import org.nutz.mvc.annotation.*;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@Ok("json:compact")
@Fail("json:compact")
@SetupBy(value = MainSetup.class)
@IocBy(type = ComboIocProvider.class,
        args = {
                "*js", "ioc/",
                "*anno", "com.yjh",
                "*tx",
                "*async",
                //"*quartz"
        }
)
@Modules
public class MainModule {
}
