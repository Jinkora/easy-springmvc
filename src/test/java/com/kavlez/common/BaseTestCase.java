package com.kavlez.common;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author Kavlez
 *         sweet_dreams@aliyun.com
 */

@ContextConfiguration("classpath*:spring-mvc.xml")
public class BaseTestCase extends AbstractJUnit4SpringContextTests {
}
