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

import com.jeequan.jeepay.ApiField;

/**
 * 分账提现记录查询
 *
 * @author yr
 * @site https://www.jeequan.com
 * @date 2024/11/20 08:46
 */
public class DivisionReceiverCashoutRecordQueryReqModel extends JeepayObject {


    @ApiField("agentNo")
    private String agentNo;      // 代理商编号

    /** 商户号 **/
    @ApiField("mchNo")
    private String mchNo;

    /** 应用ID **/
    @ApiField("appId")
    private String appId;

    /** 分账接收者ID   **/
    @ApiField("receiverId")
    private Long receiverId;

    /** 提现记录单号 **/
    @ApiField("rid")
    private String rid;

    /** 商户提现单号 **/
    @ApiField("mchOrderNo")
    private String mchOrderNo;

    /** 提现单创建时间范围：起始时间   **/
    @ApiField("queryCreatedAtBegin")
    private String queryCreatedAtBegin;

    /** 提现单创建时间范围：结束时间  **/
    @ApiField("queryCreatedAtEnd")
    private String queryCreatedAtEnd;

    /** 分页条数 默认20   **/
    @ApiField("pageSize")
    private Integer pageSize;

    /** 分页页码 默认1  **/
    @ApiField("pageNumber")
    private Integer pageNumber;

    public String getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo;
    }

    public String getMchNo() {
        return mchNo;
    }

    public void setMchNo(String mchNo) {
        this.mchNo = mchNo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getMchOrderNo() {
        return mchOrderNo;
    }

    public void setMchOrderNo(String mchOrderNo) {
        this.mchOrderNo = mchOrderNo;
    }

    public String getQueryCreatedAtBegin() {
        return queryCreatedAtBegin;
    }

    public void setQueryCreatedAtBegin(String queryCreatedAtBegin) {
        this.queryCreatedAtBegin = queryCreatedAtBegin;
    }

    public String getQueryCreatedAtEnd() {
        return queryCreatedAtEnd;
    }

    public void setQueryCreatedAtEnd(String queryCreatedAtEnd) {
        this.queryCreatedAtEnd = queryCreatedAtEnd;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
