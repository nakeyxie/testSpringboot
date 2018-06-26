//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package com.xiechy;


public enum ErrorCode {
    FAIL(-1, "common fail"),
    SUCCESS(0, "success"),
    error_pic_file(3, "非法图片文件"),
    error_pic_upload(4, "图片上传失败"),
    error_record_not_found(5, "没有找到对应的数据"),
    error_max_page_size(6, "请求记录数超出每次请求最大允许值"),
    error_create_failed(7, "新增失败"),
    error_update_failed(8, "修改失败"),
    error_delete_failed(9, "删除失败"),
    error_search_failed(10, "查询失败"),
    error_count_failed(11, "查询数据总数失败"),
    error_string_to_obj(12, "字符串转java对象失败"),
    error_invalid_argument(13, "参数不合法"),
    error_update_not_allowed(14, "更新失败：%s"),
    error_duplicated_data(15, "数据已存在"),
    error_unknown_database_operation(16, "未知数据库操作失败，请联系管理员解决"),
    error_column_unique(17, "字段s%违反唯一约束性条件"),
    error_file_download(18, "文件下载失败"),
    error_file_upload(19, "文件上传失败"),
    http_status_bad_request(400, "Bad Request"),
    http_status_unauthorized(401, "Unauthorized"),
    http_status_payment_required(402, "Payment Required"),
    http_status_forbidden(403, "Forbidden"),
    http_status_not_found(404, "Not Found"),
    http_status_method_not_allowed(405, "Method Not Allowed"),
    http_status_not_acceptable(406, "Not Acceptable"),
    http_status_proxy_authentication_required(407, "Proxy Authentication Required"),
    http_status_request_timeout(408, "Request Timeout"),
    http_status_conflict(409, "Conflict"),
    http_status_gone(410, "Gone"),
    http_status_length_required(411, "Length Required"),
    http_status_precondition_failed(412, "Precondition Failed"),
    http_status_payload_too_large(413, "Payload Too Large"),
    http_status_uri_too_long(414, "URI Too Long"),
    http_status_unsupported_media_type(415, "Unsupported Media Type"),
    http_status_requested_range_not_satisfiable(416, "Requested range not satisfiable"),
    http_status_expectation_failed(417, "Expectation Failed"),
    http_status_im_a_teapot(418, "I\'m a teapot"),
    http_status_unprocessable_entity(422, "Unprocessable Entity"),
    http_status_locked(423, "Locked"),
    http_status_failed_dependency(424, "Failed Dependency"),
    http_status_upgrade_required(426, "Upgrade Required"),
    http_status_precondition_required(428, "Precondition Required"),
    http_status_too_many_requests(429, "Too Many Requests"),
    http_status_request_header_fields_too_large(431, "Request Header Fields Too Large"),
    http_status_internal_server_error(500, "系统错误"),
    http_status_not_implemented(501, "Not Implemented"),
    http_status_bad_gateway(502, "Bad Gateway"),
    http_status_service_unavailable(503, "Service Unavailable"),
    http_status_gateway_timeout(504, "Gateway Timeout"),
    http_status_http_version_not_supported(505, "HTTP Version not supported"),
    http_status_variant_also_negotiates(506, "Variant Also Negotiates"),
    http_status_insufficient_storage(507, "Insufficient Storage"),
    http_status_loop_detected(508, "Loop Detected"),
    http_status_bandwidth_limit_exceeded(509, "Bandwidth Limit Exceeded"),
    http_status_not_extended(510, "Not Extended"),
    http_status_network_authentication_required(511, "Network Authentication Required"),
    EXCEPTION(800, "exception"),
    INVALID_PARAM(801, "invalid.param"),
    INVALID_PRIVI(802, "invalid.privi"),
    no_weekly_login(999, "没有弱登录"),
    no_login(1000, "没有登录"),
    sms_limit(1001, "短信发送频率过高"),
    sms_error(1002, "短信发送失败"),
    verifycode_no_pass(1003, "未通过校验"),
    login_invalid_username_or_password(1004, "用户名或者密码错误"),
    login_already_logined(1005, "重复登录"),
    login_permission_denied(1006, "没有操作权限"),
    login_invalid_old_password(1007, "旧密码不正确"),
    login_invalid_kaptcha(1008, "验证码错误"),
    account_invalid_acount_name(1050, "账号由2-20个字符构成"),
    account_invalid_email_format(1051, "邮件格式不正确"),
    order_operation_invalid(1101, "非法的订单操作"),
    has_bean_binded(1501, "该手机号已绑定其他账户"),
    error_phone_number(1502, "手机号码输入错误"),
    product_update_status_error(1701, "修改商品状态失败"),
    product_not_exist(1702, "该商品不存在"),
    product_used_up(1703, "库存已用完"),
    wellnessBloodGlucose_highest_lowest_avg_error(2001, "计算血糖最高值最低值平均值出错"),
    survey_question_not_exist(2101, "问卷对应问题不存在"),
    survey_answer_is_null(2102, "答案为空"),
    survey_create_version_number_error(2103, "非法创建版本号"),
    survey_only_written_once(2104, "该问卷只能填写一次"),
    survey_not_released(2105, "问卷未发布"),
    survey_code_repeated(2106, "问卷编号重复"),
    stock_sequence_initialization_not_finished(2401, "号段数据初始化未完成"),
    stock_barcode_not_found(2402, "条形码未在批次中找到"),
    stock_box_barcode_used(2403, "采样盒条形码已使用"),
    stock_collector_barcode_used(2404, "采样器条形码已使用"),
    stock_collector_number_unfit_for_box(2405, "采样器数量与采样盒类型不匹配"),
    stock_collector_types_unfit_for_box(2406, "采样器类型与采样盒类型不匹配"),
    stock_box_not_left_in_this_batch(2407, "该批次盒子已用完"),
    stock_collector_not_left_in_this_batch(2408, "该批次采样器已用完"),
    stock_batch_num_already_exist(2409, "该采购订单号已使用"),
    stock_collector_num_err(2510, "盒子应装采样器数量不符"),
    stock_storage_default_collector_storage_record_not_found(2410, "默认的采样器仓库为设置"),
    stock_collector_barcode_not_match_any_batch(2411, "采样器序列号与录入批次都不匹配"),
    stock_collector_barcode_repeat(2412, "采样器序列号重复"),
    stock_collector_type_repeat(2413, "采样器类型重复"),
    stock_batch_num_not_match_collector_type(2414, "采购订单号与采样器批次不匹配"),
    stock_to_3rd_supplier_create_failed(2701, "to第三方物流--供应商新增失败"),
    stock_to_3rd_supplier_update_failed(2702, "to第三方物流--供应商修改失败"),
    stock_to_3rd_sku_create_failed(2703, "to第三方物流--商品(sku)新增失败"),
    stock_to_3rd_sku_update_failed(2704, "to第三方物流--商品(sku)修改增失败"),
    CREATE_SF_PUTIN_ERR(2710, "创建顺丰入库单失败!"),
    id_is_used(4001, "该ID已经被占用"),
    HAVE_INIT(5000, "已经初始化"),
    NOT_INIT(5001, "号段未初始化"),
    SAMPLERSEGMENT_ADD_ERR(5002, "样本(容器)号段新增失败"),
    SAMPLERSEGMENT_DEL_ERR(5003, "样本(容器)号段删除失败"),
    SAMPLERBOXSEGMENT_ADD_ERR(5004, "样本盒号段新增失败"),
    SAMPLERBOXSEGMENT_DEL_ERR(5005, "样本盒号段删除失败"),
    SAMPLERBOXSEGMENT_NOTEXIST_ERR(5006, "样本盒序列号不存在"),
    LOGISTICORDER_ADD_ERR(5007, "物流订单新增失败"),
    LOGISTICORDER_DEL_ERR(5008, "物流订单删除失败"),
    LOGISTICORDER_UPDATE_ERR(5009, "物流订单修改失败"),
    SAMPLERSEGMENT_CHAGESTATUS_ERR(5010, "样本(容器)号段状态修改失败"),
    SAMPLERSEGMENT_STATUS_DISABLED_ERR(5011, "样本(容器)号段已被禁用"),
    SAMPLERSEGMENT_NOT_EXIST(5012, "样本(容器)号段不存在"),
    KUAIDI100_SUBSCRIBER_ERR(5013, "快递100订阅失败"),
    KUAIDI100_QUERY_ERR(5014, "快递100查询失败"),
    USER_EXIST(5100, "用户已存在"),
    USER_NOT_EXIST(5101, "用户不存在"),
    USER_PASSWORD_ERR(5102, "密码错误"),
    ROLE_NOT_EXIST(5105, "角色已存在"),
    USER_ACCESS_DENIED(5106, "用户没有访问权限"),
    USERNAME_EMAIL_ERR(5107, "用户名或邮箱不正确"),
    NULL_TOKEN(6000, "token.null"),
    CALL_API_FAIL(6001, "call.api.fail"),
    SF_FAILURE(6010, "处理失败"),
    SAMPLE_NOT_FOUND(7000, "样本不存在"),
    SAMPLE_PARENT_NOT_FOUND(7001, "父样本不存在"),
    SAMPLE_FREEZE_BOX_CELL_USED(7002, "冻存盒单元已被使用"),
    SAMPLE_FREEZE_BOX_TYPE_NOT_FOUND(7003, "冻存盒类型不存在"),
    SAMPLE_FREEZE_BOX_NOT_FOUND(7004, "冻存盒不存在"),
    SAMPLE_FREEZE_SHELF_TYPE_NOT_FOUND(7005, "冻存架类型不存在"),
    LAB_SAMPLE_EXAM_NOT_FOUND(7201, "该样本容器未绑定检测订单"),
    SAMPLE_CONTAINER_NOT_FOUND(7006, "存放容器不存在"),
    SAMPLE_DERIVE_STENCIL_EXITS(7020, "样本衍生模板已存在"),
    SAMPLE_DERIVE_STENCIL_INVALID_DETAIL(7021, "样本衍生模板明细格式不正确"),
    SAMPLE_UPLOAD_FORMAT_ERR(7022, "格式不正确，请选择xls格式"),
    SAMPLE_UPLOAD_FORMAT_ERR_1(7023, "格式不正确，请选择csv格式"),
    SAMPLE_UPLOAD_FORMAT_ERR_2(7024, "格式不正确，请选择xml格式"),
    SAMPLE_UPLOAD_RESULT_FILE_ERR(7025, "任务单名称不匹配,请重新选择"),
    DNA_TASK_FINISHED_ERR(7026, "该任务单已完成,不能重新导入实验结果"),
    SAMPLE_UPLOAD_DNA_SALT_ERR(7028, "导入数据数量不少于样本数量的2倍"),
    SAMPLE_SHOULD_NUMBER_ERR(7029, "排版孔位数量与样本列表数量不匹配"),
    SAMPLES_COUNT_PLAN_ACTUAL(7030, "实际样本数量与计划样本数量不符"),
    SAMPLE_FLOW_NOT_EXIST_ERR(7035, "样本不存在实验流程"),
    SAMPLE_FLOW_EXIST_ERR(7036, "样本已存在实验流程");

    private int code;
    private String msg;

    private ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static int getCode(String define) {
        try {
            return valueOf(define).code;
        } catch (IllegalArgumentException var2) {
            return FAIL.getErrorCode();
        }
    }

    public static String getMsg(String define) {
        try {
            return valueOf(define).msg;
        } catch (IllegalArgumentException var2) {
            return FAIL.getErrorMsg();
        }
    }

    public static String getMsg(int code) {
        ErrorCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ErrorCode err = var1[var3];
            if(err.code == code) {
                return err.msg;
            }
        }

        return "errorCode not defined ";
    }

    public int getErrorCode() {
        return this.code;
    }

    public String getErrorMsg() {
        return this.msg;
    }

    static {
    }
}
