package org.huihui.easysqlite.compiler;

import com.google.auto.service.AutoService;

import org.huihui.easysqlite.annotation.Table;

import java.lang.reflect.Field;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/**
 * User: huihui
 * Date: 2017-01-10 {HOUR}:47
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)//java版本支持
@SupportedAnnotationTypes({//标注注解处理器支持的注解类型
        "org.huihui.easysqlite.annotation.PrimaryKey",
        "org.huihui.easysqlite.annotation.Rename",
        "org.huihui.easysqlite.annotation.Table"
})
public class AnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(Table.class);
        if (elements!=null) {
            for (Element element : elements) {
                Field[] fields = element.getClass().getFields();
                if (fields!=null) {
                    for (Field field : fields) {
                        field.setAccessible(true);
                    }



                }

            }
        }
        return true;
    }
}