package com.rayvision.mapper;

import com.rayvision.domain.Resources;
import com.rayvision.security.GrantedResources;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuyangyang on 2017/11/10.
 */
@Repository
public interface ResourcesMapper {

    List<Resources> findResourcesByPermissionId(Integer userId);

    List<GrantedResources> findGrantedResources();
}
