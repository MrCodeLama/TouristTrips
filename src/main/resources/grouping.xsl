<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">

    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/TouristVouchers">
        <GroupedVouchers>
            <xsl:for-each-group select="TouristVoucher" group-by="Country">
                <xsl:element name="{current-grouping-key()}">
                    <xsl:for-each select="current-group()">
                        <xsl:copy-of select="."/>
                    </xsl:for-each>
                </xsl:element>
            </xsl:for-each-group>
        </GroupedVouchers>
    </xsl:template>

</xsl:stylesheet>
