package com.bhus.studentApp2.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ABB {
    private String mihpayid;
    private String request_id;
    private String bank_ref_num;
    private String amt;
    private String transaction_amount;
    private String txnid;
    private String additional_charges;
    private String productinfo;
    private String firstname;
    private String bankcode;
    private String udf1;
    private String udf3;
    private String udf4;
    private String udf5;
    private String field2;
    private String field9;
    private String error_code;
    private String addedon;
    private String payment_source;
    private String card_type;
    private String error_Message;
    private Integer net_amount_debit;
    private String disc;
    private String mode;
    private String PG_TYPE;
    private String  card_no;
    private String udf2;
    private String status;
    private String unmappedstatus;
    private String Merchant_UTR;
    private String Settled_At;
    private String App_Name;

}
