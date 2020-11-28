package com.cybertek.converter;

import com.cybertek.dto.RoleDTO;
import com.cybertek.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
// bu annotation ile, whenever you run your application and whenever it comes to Role, it is gonna make conversion automatically
public class RoleDtoConverter implements Converter<String , RoleDTO> {
// springframework te olan Converter interface ile String->Object veya Object->String e convert ediliyor
//    Converter<S,T>, burada S->source, T->target anlamında

    @Autowired
    RoleService roleService;

    @Override
    public RoleDTO convert(String source) {

        Long id=Long.parseLong(source);

        RoleDTO object=new RoleDTO();

        object=roleService.findById(id);

        return object;
    }
}
