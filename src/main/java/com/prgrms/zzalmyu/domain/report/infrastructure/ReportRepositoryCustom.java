package com.prgrms.zzalmyu.domain.report.infrastructure;

import java.time.LocalDateTime;

public interface ReportRepositoryCustom {

    LocalDateTime getThirdReportAt(Long imageId);
}
