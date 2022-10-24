package com.gsg.calculator.enums;

/* Tax rates are populated from Wikipedia
* (https://en.wikipedia.org/wiki/List_of_countries_by_tax_rates GST/VAT section)
**/
public enum TaxRateProvider {
    AF(0.0),
    ALB(20.0),
    DZ(19.0),
    AS(0.0),
    AD(4.5),
    AO(10.0),
    AI(0.0),
    AG(15.0),
    AR(21.0),
    AM(20.0),
    AW(1.5),
    AU(10.0),
    AT(20.0),
    AZ(18.0),
    BS(12.0),
    BH(10.0),
    BB(15.0),
    BD(17.0),
    BY(20.0),
    BE(21.0),
    BZ(12.5),
    BJ(18.0),
    BM(0.0),
    BT(null),
    BO(13.0),
    BA(17.0),
    BW(14.0),
    BR(19.0),
    BN(null),
    BG(20.0),
    BF(18.0),
    BI(18.0),
    KH(10.0),
    CM(19.25),
    CA(15.0),
    CV(15.0),
    KY(0.0),
    CF(19.0),
    TD(null),
    CL(19.0),
    CN(13.0),
    CO(19.0),
    KM(null),
    CK(15.0),
    CG(18.9),
    CR(13.0),
    HR(25.0),
    CU(20.0),
    CW(9.0),
    CY(19.0),
    CZ(21.0),
    DK(25.0),
    DJ(null),
    DM(15.0),
    DO(18.0),
    EC(12.0),
    EG(14.0),
    SV(13.0),
    GQ(15.0),
    ER(null),
    EE(20.0),
    ET(null),
    FK(0.0),
    FJ(9.0),
    FI(24.0),
    FR(20.0),
    GA(18.0),
    GM(null),
    DE(19.0),
    GE(18.0),
    GH(3.0),
    GI(0.0),
    GR(24.0),
    GD(null),
    GT(12.0),
    GN(null),
    GW(null),
    GY(14.0),
    HT(10.0),
    HN(null),
    HK(0.0),
    HU(27.0),
    IS(24.0),
    IN(18.0),
    ID(11.0),
    IR(9.0),
    IQ(10.0),
    IE(23.0),
    IM(20.0),
    IL(17.0),
    IT(22.0),
    JM(20.0),
    JP(10.0),
    JE(5.0),
    JO(16.0),
    KZ(13.0),
    KE(16.0),
    KI(null),
    KW(0.0),
    KG(12.0),
    KP(4.0),
    KR(10.0),
    LA(null),
    LV(21.0),
    LB(11.0),
    LS(null),
    LR(null),
    LY(null),
    LI(7.7),
    LT(21.0),
    LU(17.0),
    MO(0.0),
    MG(null),
    MW(null),
    MY(10.0),
    MV(6.0),
    ML(null),
    MT(18.0),
    MH(4.0),
    MU(15.0),
    MX(16.0),
    MD(20.0),
    MC(19.6),
    MN(10.0),
    ME(21.0),
    MR(null),
    MS(null),
    MA(20.0),
    MZ(null),
    MM(null),
    NA(15.0),
    NR(null),
    NP(13.0),
    NL(21.0),
    NZ(15.0),
    NC(null),
    NI(null),
    NE(7.0),
    NG(7.5),
    NU(12.5),
    NF(null),
    NO(25.0),
    OM(5.0),
    PK(17.0),
    PW(null),
    PS(14.5),
    PA(7.0),
    PG(null),
    PY(10.0),
    PE(16.0),
    PH(12.0),
    PN(null),
    PO(23.0),
    PT(23.0),
    PR(11.5),
    QA(0.0),
    RO(19.0),
    RU(20.0),
    RW(18.0),
    KN(null),
    LC(null),
    PM(null),
    VC(null),
    WS(null),
    SM(0.0),
    ST(null),
    SA(15.0),
    SN(20.0),
    RS(20.0),
    SC(15.0),
    SL(null),
    SG(7.0),
    SX(null),
    SK(20.0),
    SI(22.0),
    SB(null),
    SO(null),
    ZA(15.0),
    SS(0.0),
    ES(21.0),
    LK(12.0),
    SD(null),
    SR(null),
    SE(25.0),
    CH(7.7),
    SY(null),
    TW(5.0),
    TJ(18.0),
    TZ(18.0),
    TH(7.0),
    CD(20.0),
    TG(null),
    TK(null),
    TO(null),
    TT(12.5),
    TN(18.0),
    TR(18.0),
    TM(null),
    TC(null),
    TV(null),
    UG(18.0),
    UA(20.0),
    AE(0.0),
    GB(20.0),
    US(11.5),
    UY(22.0),
    UZ(15.0),
    VU(null),
    VE(16.0),
    VG(null),
    VI(0.0),
    VN(10.0),
    YE(2.0),
    ZM(16.0),
    ZW(15.0);

    private final Double taxRate;

    TaxRateProvider(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getTaxRate() {
        return this.taxRate;
    }
}