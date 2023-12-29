package vn.edu.ptit.toiec.presentation.model;

import lombok.*;
import vn.edu.ptit.toiec.data.entities.Part;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartRequest {

    private Long id;
    private String numberPart;
    private String partName;
    private String partDesc;

    public PartRequest convertByPart(Part part) {
        this.id = part.getId();
        this.numberPart = part.getNumberPart();
        this.partName = part.getPartName();
        this.partDesc = part.getPartDesc();
        return this;
    }
}
