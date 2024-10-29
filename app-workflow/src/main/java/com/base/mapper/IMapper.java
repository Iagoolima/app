package com.base.mapper;


import com.base.domain.User;

import java.util.Optional;

public interface IMapper<TDto, TDomain> {

    TDomain toDomain(TDto dto);

    TDto toDto(TDomain domain);
}
