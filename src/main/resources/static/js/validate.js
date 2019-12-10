$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
    $('#addGoodsForm').validate({
        rules: {
            goodsName: {
                required: true,
                minlength: 1
            },
            model: {
                required: true,
                minlength: 1
            },
            unit: {
                required: true,
                minlength: 1
            },
            price: {
                required: true,
                min: 1
            }

        },
        messages: {
            goodsName: {
                required: "请输入商品名",
                minlength: "最少一个字符"
            },
            model: {
                required: "请输入型号",
                minlength: "最少一个字符"
            },
            unit: {
                required: "请输入单位"
            },
            price: {
                required: "请输入价格",
                number: "请输入一个正确的价格"
            }
        }
    });
    $('#orderAddForm').validate({
        rules: {
            goodsId: {
                required: true,
                minlength: 1
            },
            flag: {
                required: true,
                minlength: 1
            },
            num: {
                required: true,
                min: 1
            },
            price: {
                required: true,
                min: 1
            }

        },
        messages: {
            goodsId: {
                required: "请选择一个商品",
                minlength: "最少一个字符"
            },
            flag: {
                required: "请选择入库/出库",
                minlength: "最少一个字符"
            },
            num: {
                required: "请输入数量"
            },
            price: {
                required: "请输入价格"
            }
        }
    })
});