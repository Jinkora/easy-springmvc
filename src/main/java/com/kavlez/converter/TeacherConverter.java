package com.kavlez.converter;

import com.kavlez.pojo.Teacher;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
 *
 * <pre>
 * 数据绑定的核心部件是org.springframework.validation.DataBinder
 * mvc框架将servletRequest和请求参数对象传递给DataBinder
 * DataBinder调用Spring web context中的ConversionService进行数据的结构化和转换
 * 然后调用Validator组件对数据对象进行校验,生成绑定结果,即org.springframework.validation.BindingResult
 * 最后从BindingResult中抽取数据对象,赋予处理方法的相应入参
 * </pre>
 *
 * @see org.springframework.core.convert.converter.Converter
 */
public class TeacherConverter implements Converter<String, Teacher> {
    @Override
    public Teacher convert(String source) {
        if (StringUtils.isBlank(source))
            throw new IllegalArgumentException("source is empty");

        Teacher teacher = new Teacher();
        teacher.setName(source);

        return teacher;
    }
}
