/*
 * Copyright (c) 2021-2031, 河北计全科技有限公司 (https://www.jeequan.com & jeequan@126.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jeequan.jeepay.model;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 分账提现记录查询
 *
 * @author yr
 * @site https://www.jeequan.com
 * @date 2024/11/20 08:46
 */
public class DivisionReceiverCashoutRecordQueryResModel extends JeepayObject {

    /**
     * 分账接收者ID
     */
    private Long receiverId;

    /** 记录明细 **/
    private List<JSONObject> records;

    /** 总条数 **/
    private Long total;

    /** 当前页码 **/
    private Long current;

    /** 是否有下一页 **/
    private Boolean hasNext;

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public List<JSONObject> getRecords() {
        return records;
    }

    public void setRecords(List<JSONObject> records) {
        this.records = records;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }
}
