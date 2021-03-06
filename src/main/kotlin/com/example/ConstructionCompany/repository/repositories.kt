package com.example.ConstructionCompany.repository

import com.example.ConstructionCompany.entity.*
import com.example.ConstructionCompany.entity.query.MaterialConsumptionReport
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.PagingAndSortingRepository

/*Репозиторий с общими операциями*/
@NoRepositoryBean
interface AbstractRepository<T, ID> : PagingAndSortingRepository<T, ID> {
    fun findById(id: ID, pageable: Pageable): Page<T>
    fun deleteByIdIn(ids: Collection<ID>)
    fun findAll(spec: Specification<T>?, pageable: Pageable): Page<T>
}

/*Конкретные репозитории добавляют функции для фильтрации ссылающихся сущностей по конкретному id*/
interface BrigadeMemberRepository : AbstractRepository<BrigadeMember, Long> {
    fun findAllByBrigadeId(id: Long, pageable: Pageable): Page<BrigadeMember>
    fun findAllByStaffId(id: Long, pageable: Pageable): Page<BrigadeMember>

}

interface BrigadeRepository : AbstractRepository<Brigade, Long> {
    fun findAllByTitleId(id: Long, pageable: Pageable): Page<Brigade>
}

interface BuildObjectRepository : AbstractRepository<BuildObject, Long> {
    fun findAllByPrototypeId(id: Long, pageable: Pageable): Page<BuildObject>
    fun findAllByPlotId(id: Long, pageable: Pageable): Page<BuildObject>
    fun findAllByCustomerId(id: Long, pageable: Pageable): Page<BuildObject>
}

interface CustomerRepository : AbstractRepository<Customer, Long>

interface EstimateRepository : AbstractRepository<Estimate, Long> {
    fun findAllByWorkScheduleId(id: Long, pageable: Pageable): Page<Estimate>
    fun findAllByMaterialId(id: Long, pageable: Pageable): Page<Estimate>


}

interface MachineryRepository : AbstractRepository<Machinery, Long> {
    fun findAllByModelId(id: Long, pageable: Pageable): Page<Machinery>
    fun findAllByManagementId(id: Long, pageable: Pageable): Page<Machinery>


}

interface MachineryModelRepository : AbstractRepository<MachineryModel, Long> {
    fun findAllByMachineryTypeId(id: Long, pageable: Pageable): Page<MachineryModel>

}

interface MachineryTypeRepository : AbstractRepository<MachineryType, Long>

interface ManagementRepository : AbstractRepository<Management, Long> {
    fun findAllByChiefId(id: Long, pageable: Pageable): Page<Management>

}

interface MaterialRepository : AbstractRepository<Material, Long>

interface MaterialConsumptionRepository : AbstractRepository<MaterialConsumption, Long> {
    fun findAllByObjectBrigadeId(id: Long, pageable: Pageable): Page<MaterialConsumption>
    fun findAllByEstimateId(id: Long, pageable: Pageable): Page<MaterialConsumption>
}

interface ObjectBrigadeRepository : AbstractRepository<ObjectBrigade, Long> {
    fun findAllByBrigadeId(id: Long, pageable: Pageable): Page<ObjectBrigade>
    fun findAllByBuildObjectId(id: Long, pageable: Pageable): Page<ObjectBrigade>
    fun findAllByWorkScheduleId(id: Long, pageable: Pageable): Page<ObjectBrigade>


}

interface ObjectMachineryRepository : AbstractRepository<ObjectMachinery, Long> {
    fun findAllByBuildObjectId(id: Long, pageable: Pageable): Page<ObjectMachinery>
    fun findAllByMachineryId(id: Long, pageable: Pageable): Page<ObjectMachinery>


}

interface PlotRepository : AbstractRepository<Plot, Long> {
    fun findAllByChiefId(id: Long, pageable: Pageable): Page<Plot>
    fun findAllByManagementId(id: Long, pageable: Pageable): Page<Plot>

}

interface PrototypeRepository : AbstractRepository<Prototype, Long> {
    fun findAllByPrototypeTypeId(id: Long, pageable: Pageable): Page<Prototype>

}

interface PrototypeTypeRepository : AbstractRepository<PrototypeType, Long>

interface StaffRepository : AbstractRepository<Staff, Long> {
    fun findAllByTitleId(id: Long, pageable: Pageable): Page<Staff>
    fun findAllByChiefId(id: Long, pageable: Pageable): Page<Staff>
}

interface TitleRepository : AbstractRepository<Title, Long> {
    fun findAllByTitleCategoryId(id: Long, pageable: Pageable): Page<Title>
}

interface TitleCategoryRepository : AbstractRepository<TitleCategory, Long>

interface WorkScheduleRepository : AbstractRepository<WorkSchedule, Long> {
    fun findAllByPrototypeId(id: Long, pageable: Pageable): Page<WorkSchedule>
    fun findAllByWorkTypeId(id: Long, pageable: Pageable): Page<WorkSchedule>


}

interface WorkTypeRepository : AbstractRepository<WorkType, Long>

interface ReportRepository : AbstractRepository<Report, Long>

interface MaterialConsumptionReportRepository : AbstractRepository<MaterialConsumptionReport, Long> {
    fun findAllByReportId(id: Long, pageable: Pageable): Page<MaterialConsumptionReport>
}
