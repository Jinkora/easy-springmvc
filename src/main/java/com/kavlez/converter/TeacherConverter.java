package com.kavlez.converter;

import com.kavlez.pojo.Teacher;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * @author: Kavlez
 * sweet_dreams@aliyun.com
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
