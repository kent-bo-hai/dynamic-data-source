/**
 * Copyright (C) 2017-2018 kent(kent.bohai@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kent.datasource.aspect;

import com.kent.datasource.DataSourceContextHolder;
import com.kent.datasource.annotation.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * @author kongtong.ouyang on 2018/2/2.
 */
@Aspect
public class DynamicDataSourceAspect {

    @Around(value = "execution(* *.*(..))")
    public Object getTargetDataSource(ProceedingJoinPoint point) throws Throwable {
        Object target = point.getTarget();

        MethodSignature signature = (MethodSignature) point.getSignature();

        DataSource dataSource = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);

        if (dataSource == null) {
            dataSource = AnnotationUtils.findAnnotation(target.getClass(), DataSource.class);
        }

        if (dataSource == null) {
            return point.proceed();
        }

        Object result;
        try {
            DataSourceContextHolder.set(dataSource.value());
            result = point.proceed();
        } finally {
            DataSourceContextHolder.remove();
        }
        return result;
    }

}
