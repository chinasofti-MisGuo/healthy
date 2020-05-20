package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.Report;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ReportDTO extends BaseDTO implements Serializable {

    private String describe;

    private Long dynamicId;

    private Long whistleUid;

    private Long receiveUid;

    private Integer typeId;

    private String phone;

    private String image;

    public Report convertToReport(){
        ReportDtoConvert reportDtoConvert = new ReportDtoConvert();
        return reportDtoConvert.doForward(this);
    }

    private static class ReportDtoConvert extends BaseDtoConvert<ReportDTO, Report>{
        @Override
        protected Report doForward(ReportDTO reportDTO) {
            Report report = new Report();
            BeanUtils.copyProperties(reportDTO, report);
            return report;
        }

        @Override
        protected ReportDTO doBackward(Report report) {
            return null;
        }
    }

}
