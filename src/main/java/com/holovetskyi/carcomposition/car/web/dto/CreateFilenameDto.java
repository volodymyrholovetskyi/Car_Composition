package com.holovetskyi.carcomposition.car.web.dto;

import javax.validation.constraints.NotBlank;

public class CreateFilenameDto {
    @NotBlank(message = "{filename.error}")
    public String filename;

}
