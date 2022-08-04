package com.tao.component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanLive {

    public void initMethod() {
        log.debug("HappyComponent初始化");
    }

    public void destroyMethod() {
        log.debug("HappyComponent销毁");
    }
}
