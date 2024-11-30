package com.lyc.lease.web.admin.controller.apartment;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lyc.lease.common.result.Result;
import com.lyc.lease.model.entity.LabelInfo;
import com.lyc.lease.model.enums.ItemType;
import com.lyc.lease.web.admin.service.LabelInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "标签管理")
@RestController
@RequestMapping("/admin/label")
public class LabelController {

    @Autowired
    private LabelInfoService service;

    @Operation(summary = "（根据类型）查询标签列表")
    @GetMapping("list")
     //Spring WVC 中的 WebDataBinder 将HTTP请求参数绑定到Controller方法参数
     //WebDataBinder 依靠Converter实现                      // required 可选参数
    public Result<List<LabelInfo>> labelList(@RequestParam(required = false) ItemType type) {
        System.out.println(type);
        //MybatisPlus 中的 TypeHandler 完成 Java对象 和 数据库 数据类型转换
        LambdaQueryWrapper<LabelInfo> queryWrapper = new LambdaQueryWrapper<>();
        // 如果type不为null，则添加查询条件，匹配LabelInfo的type字段
        queryWrapper.eq(type != null,LabelInfo::getType,type);
        List<LabelInfo> labelInfos = service.list(queryWrapper);
        return Result.ok(labelInfos);
    }

    @Operation(summary = "新增或修改标签信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdateLabel(@RequestBody LabelInfo labelInfo) {
        //SpringMVC中的`HTTPMessageConverter`组件负责将Controller方法的返回值（Java对象）转换为HTTP响应体中的JSON字符串
        service.saveOrUpdate(labelInfo);
        return Result.ok();
    }

    @Operation(summary = "根据id删除标签信息")
    @DeleteMapping("deleteById")
    public Result deleteLabelById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }
}
