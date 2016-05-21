<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Customer details</h2>
                <table border="1">
                    <tr>
                        <th style="text-align:left">Company Name</th>
                        <th style="text-align:left">Contact Name</th>
                    </tr>
                    <xsl:for-each select="Customers/Customer">
                        <tr>
                            <td><xsl:value-of select="CompanyName"/></td>
                            <td><xsl:value-of select="ContactName"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>