<h2>Features Accross Projects (Headless) Application for keeping records of features developed in projects of an Organisation.</h2>
<h4>Stateless REST API.</h4>
<h5>Technology Used - </h5>
<ul>
	<li>SpringBoot 3.1.0</li>
	<li>Java - OpenJDK 17.0.2</li>
	<li>Hibernate - 6.2.2Final</li>
	<li>PostgreSQL database</li>
	<li>ehcache - 2.10.1</li>
</ul>
<h4>Benefits of Application - </h4>
<ol>
<li>Search feature/integration implemented across already build project(s)</li>
<li>Looking for reusable assets features/integrations</li>
<li>Usage static data of features built across projects for RFPs/Sales Proposals</li>
<li>Product Managers to upgrade them on the features and their workflows</li>
<li>Provision to add more advanced features and projects inside application</li>
</ol>	

<h4>API Documentation - </h4>
<h5><u>Get Form Input data:</u> </h5>
<p><u>Api Details:</u> Rest API to get 'addproject' and 'addfeature' form input data from predefined value list.</p>
URL endpoint - {hostname}/data/forminputdata<br />
http method - "GET"<br />
produces only "application/json"
<pre>
responsebody - <br />
{
    "error": false,<br />
    "message": null,<br />
    "data": {<br />
        "clientType": [<br />
            "External",<br />
            "Link Partner",<br />
            "client_base",<br />
            "Internal"<br />
        ],<br />
        "regions": [<br />
            {<br />
                "region_id": "US",<br />
                "region_name": "United States of America"<br />
            },<br />
            {<br />
                "region_id": "CA",<br />
                "region_name": "Canada"<br />
            },<br />
            {<br />
                "region_id": "ES",<br />
                "region_name": "Spain"<br />
            },<br />
            {<br />
                "region_id": "FR",<br />
                "region_name": "France"<br />
            }<br />
        ],<br />
        "projectNames": [<br />
            "Jenny Craig",<br />
            "WorkDay"<br />
        ],<br />
        "practiceNames": [<br />
            "Salesforce B2C",<br />
            "SFCC"<br />
        ],<br />
        "sectorNames": [<br />
            "Retail",<br />
            "HealthCare",<br />
            "FMCG"<br />
        ],<br />
        "categories": [<br />
            {<br />
                "category_name": "ScreenRecording",<br />
                "category_description": null<br />
            },<br />
            {<br />
                "category_name": "Payment",<br />
                "category_description": null<br />
            },<br />
            {<br />
                "category_name": "Shop the look",<br />
                "category_description": null<br />
            }<br />
        ],<br />
        "domainNames": [<br />
            "eCommerce"<br />
        ],<br />
        "projectContactPoint": [<br />
            {<br />
                "user_id": "Suman123653",<br />
                "company_id": null,<br />
                "first_name": "Suman",<br />
                "last_name": null,<br />
                "email": null,<br />
                "displayName": "Suman "<br />
            },<br />
            {<br />
                "user_id": "Kazitanvir124678",<br />
                "company_id": null,<br />
                "first_name": "Kazi",<br />
                "last_name": "tanvir Azad",<br />
                "email": null,<br />
                "displayName": "Kazi tanvir Azad"<br />
            }<br />
        ],<br />
        "subCategories": [<br />
            "CustomFeature",<br />
            "Tracking",<br />
            "SF Integration",<br />
        ]<br />
    }<br />
}<br />
</pre>
<h5><u>Add New Project: </u></h5>
<p><u>Api Details:</u> Rest API to add new project to the database.</p>
URL endpoint - {hostname}/project/addproject<br />
http method - "POST"<br />
<pre>
requestbody -<br />
{<br />
    "project_name": "WorkDay",<br />
    "regions": [<br />
        {<br />
            "region_id": "US"<br />
        },<br />
        {<br />
            "region_id": "CA"<br />
        },<br />
        {<br />
            "region_id": "UK"<br />
        }<br />
    ],<br />
    "sector": {<br />
        "sector_name": "Retail"<br />
    },<br />
    "project_contact_point": {<br />
        "user_id": "Kazitanvir124678"<br />
    },<br />
    "multi_brand": true,<br />
    "brandnames": "Recruiting portal, HR portal",<br />
    "multi_site": true,<br />
    "project_notes": "Portal for recruitment",<br />
    "last_served_year": "2021",<br />
    "clientLead": {<br />
        "client_type": "External"<br />
    },<br />
    "practice": {<br />
        "practice_name": "Salesforce B2C"<br />
    },<br />
    "domain": {<br />
        "domain_name": "eCommerce"<br />
    }<br />
}<br />
<b>**Custom fields value can be achieved from 'forminputdata' api. 'project_name' is a mandatory field.<br /> Empty or null value in 'project_name' will return error in the response for the field. 'project_name' value must be unique.<br /> Throws error in response if 'project_name' already exists.</b>
</pre>
<h5><u>Get Project List: </u></h5>
<p><u>Api Details:</u> Rest API to retrieve all the available Projects from the database.</p>
URL endpoint - {hostname}/project/getprojects<br />
http method - "GET"<br />
<pre>
responsebody -<br />
{<br />
    "error": false,<br />
    "message": null,<br />
    "data": [<br />
        {<br />
            "project_name": "WorkDay",<br />
            "id": 0,<br />
            "regions": [<br />
                {<br />
                    "region_id": "US",<br />
                    "region_name": "United States of America"<br />
                },<br />
                {<br />
                    "region_id": "CA",<br />
                    "region_name": "Canada"<br />
                },<br />
                {<br />
                    "region_id": "UK",<br />
                    "region_name": "United Kingdom"<br />
                }<br />
            ],<br />
            "sector": {<br />
                "sector_name": "Retail"<br />
            },<br />
            "project_contact_point": {<br />
                "user_id": "Kazitanvir124678",<br />
                "company_id": null,<br />
                "first_name": "Kazi",<br />
                "last_name": "tanvir Azad",<br />
                "email": null,<br />
                "displayName": "Kazi tanvir Azad"<br />
            },<br />
            "multi_brand": true,<br />
            "brandnames": "Recruiting portal, HR portal",<br />
            "multi_site": true,<br />
            "project_notes": "Portal for recruitment",<br />
            "last_served_year": "2021",<br />
            "clientLead": {<br />
                "client_type": "External"<br />
            },<br />
            "practice": {<br />
                "practice_name": "Salesforce B2C"<br />
            },<br />
            "domain": {<br />
                "domain_name": null<br />
            }<br />
        }<br />
    ]<br />
}<br />
<b>**Cached api. Cache age is defined and can configured by changing the 'timeToIdleSeconds' attribute value in src/main/resources/ehcache.xml</b>
</pre>
<h5><u>Add New Feature: </u></h5>
<p><u>Api Details:</u> Rest API to add new Feature to the database.</p>
URL endpoint - {hostname}/feature/addfeature<br />
http method - "POST"<br />
<pre>
requestbody -<br />
{<br />
    "feature_ref": "recruitment portal",<br />
    "feature_name": "Recruitment Portal",<br />
    "project_name": "WorkDay",<br />
    "category": {<br />
        "category_name": "Customizer"<br />
    },<br />
    "sub_category": {<br />
        "subcategory_name": "CustomFeature"<br />
    },<br />
    "desc": "Recruit candidates through AI",<br />
    "feature_type": "AI implementation",<br />
    "project_contact_point": {<br />
        "user_id": "Rachit806426"<br />
    },<br />
    "artifact_detail": "Recruitment Portal",<br />
    "used_year": "2022",<br />
    "feature_extended": false,<br />
    "alternate_contact_point": {<br />
        "user_id": "Bharath790454"<br />
    }<br />
}<br />
<b>**Custom fields value can be achieved from 'forminputdata' api. 'feature_ref' is a mandatory field.<br /> Empty or null value in 'feature_ref' will return error in the response for the field. 'feature_ref' value must be unique.<br /> Throws error in response if 'feature_ref' already exists.</b>
</pre>
<h5><u>Get FeatureProject data:</u> </h5>
<p><u>Api Details:</u> Rest API to retrieve all the available FeatureProject from the database.</p>
URL endpoint - {hostname}/featureprojects/getfeatureprojects<br />
http method - "GET"<br />
<pre>
responsebody -<br />
{<br />
    "error": false,<br />
    "message": null,<br />
    "data": [<br />
        {<br />
            "id": 0,<br />
            "feature": {<br />
                "feature_ref": "recruitment portal",<br />
                "id": 0,<br />
                "project_name": null,<br />
                "feature_name": "Recruitment Portal",<br />
                "category": {<br />
                    "category_name": "Customizer",<br />
                    "category_description": null<br />
                },<br />
                "sub_category": {<br />
                    "subcategory_name": "CustomFeature",<br />
                    "subcategory_description": null<br />
                },<br />
                "desc": "Recruit candidates through AI",<br />
                "feature_type": "AI implementation",<br />
                "project_contact_point": {<br />
                    "user_id": "Rachit806426",<br />
                    "company_id": null,<br />
                    "first_name": "Rachit",<br />
                    "last_name": "Goel",<br />
                    "email": null,<br />
                    "displayName": "Rachit Goel"<br />
                },<br />
                "artifact_detail": "Recruitment Portal",<br />
                "used_year": "2022",<br />
                "feature_extended": false,<br />
                "alternate_contact_point": {<br />
                    "user_id": "Bharath790454",<br />
                    "company_id": null,<br />
                    "first_name": "Bharath",<br />
                    "last_name": "Reddy",<br />
                    "email": null,<br />
                    "displayName": "Bharath Reddy"<br />
                }<br />
            },<br />
            "project": {<br />
                "project_name": "WorkDay",<br />
                "id": 0,<br />
                "regions": [<br />
                    {<br />
                        "region_id": "US",<br />
                        "region_name": "United States of America"<br />
                    },<br />
                    {<br />
                        "region_id": "CA",<br />
                        "region_name": "Canada"<br />
                    }<br />
                ],<br />
                "sector": {<br />
                    "sector_name": "Retail"<br />
                },<br />
                "project_contact_point": {<br />
                    "user_id": "Kazitanvir124678",<br />
                    "company_id": null,<br />
                    "first_name": "Kazi",<br />
                    "last_name": "tanvir Azad",<br />
                    "email": null,<br />
                    "displayName": "Kazi tanvir Azad"<br />
                },<br />
                "multi_brand": true,<br />
                "brandnames": "Recruiting portal, HR portal",<br />
                "multi_site": true,<br />
                "project_notes": "Portal for recruitment",<br />
                "last_served_year": "2021",<br />
                "clientLead": {<br />
                    "client_type": "External"<br />
                },<br />
                "practice": {<br />
                    "practice_name": "Salesforce B2C"<br />
                },<br />
                "domain": {<br />
                    "domain_name": null<br />
                }<br />
            },<br />
            "artifact_detail": "Recruitment Portal",<br />
            "poc": {<br />
                "user_id": "Rachit806426",<br />
                "company_id": null,<br />
                "first_name": "Rachit",<br />
                "last_name": "Goel",<br />
                "email": null,<br />
                "displayName": "Rachit Goel"<br />
            },<br />
            "used_year": "2022",<br />
            "feature_extended": false,<br />
            "alternate_poc": {<br />
                "user_id": "Bharath790454",<br />
                "company_id": null,<br />
                "first_name": "Bharath",<br />
                "last_name": "Reddy",<br />
                "email": null,<br />
                "displayName": "Bharath Reddy"<br />
            }<br />
        }<br />
    ]<br />
}<br />
</pre>
<h5><u>Search FeatureProject data: </u></h5>
<p><u>Api Details:</u> Rest API to retrieve all the available FeatureProject from the database matching with <br/>
search keyword from the query parameter. Search execution is based on the following attributes <br/>
<ul>
<li>project_name</li>
<li>feature_ref</li>
<li>artifact_detail</li>
<li>user_id</li>
<li>used_year</li>
<li>sector_name</li>
<li>client_base</li>
<li>feature_name</li>
<li>category_name</li>
<li>subcategory_name</li>
<li>feature_type</li>
</ul>
</p>
URL endpoint - {hostname}/featureprojects/search?keyword={searchkeyword}<br />
http method - "GET"<br />
searchkeyword = workday<br />
<pre>
responsebody -<br />
{<br />
    "error": false,<br />
    "message": null,<br />
    "data": [<br />
         {<br />
            "id": 0,<br />
            "feature": {<br />
                "feature_ref": "recruitment portal",<br />
                "id": 0,<br />
                "project_name": null,<br />
                "feature_name": "Recruitment Portal",<br />
                "category": {<br />
                    "category_name": "Customizer",<br />
                    "category_description": null<br />
                },<br />
                "sub_category": {<br />
                    "subcategory_name": "CustomFeature",<br />
                    "subcategory_description": null<br />
                },<br />
                "desc": "Recruit candidates through AI",<br />
                "feature_type": "AI implementation",<br />
                "project_contact_point": {<br />
                    "user_id": "Rachit806426",<br />
                    "company_id": null,<br />
                    "first_name": "Rachit",<br />
                    "last_name": "Goel",<br />
                    "email": null,<br />
                    "displayName": "Rachit Goel"<br />
                },<br />
                "artifact_detail": "Recruitment Portal",<br />
                "used_year": "2022",<br />
                "feature_extended": false,<br />
                "alternate_contact_point": {<br />
                    "user_id": "Bharath790454",<br />
                    "company_id": null,<br />
                    "first_name": "Bharath",<br />
                    "last_name": "Reddy",<br />
                    "email": null,<br />
                    "displayName": "Bharath Reddy"<br />
                }<br />
            },<br />
            "project": {<br />
                "project_name": "WorkDay",<br />
                "id": 0,<br />
                "regions": [<br />
                    {<br />
                        "region_id": "US",<br />
                        "region_name": "United States of America"<br />
                    },<br />
                    {<br />
                        "region_id": "CA",<br />
                        "region_name": "Canada"<br />
                    },<br />
                    {<br />
                        "region_id": "UK",<br />
                        "region_name": "United Kingdom"<br />
                    }<br />
                ],<br />
                "sector": {<br />
                    "sector_name": "Retail"<br />
                },<br />
                "project_contact_point": {<br />
                    "user_id": "Kazitanvir124678",<br />
                    "company_id": null,<br />
                    "first_name": "Kazi",<br />
                    "last_name": "tanvir Azad",<br />
                    "email": null,<br />
                    "displayName": "Kazi tanvir Azad"<br />
                },<br />
                "multi_brand": true,<br />
                "brandnames": "Recruiting portal, HR portal",<br />
                "multi_site": true,<br />
                "project_notes": "Portal for recruitment",<br />
                "last_served_year": "2021",<br />
                "clientLead": {<br />
                    "client_type": "External"<br />
                },<br />
                "practice": {<br />
                    "practice_name": "Salesforce B2C"<br />
                },<br />
                "domain": {<br />
                    "domain_name": null<br />
                }<br />
            },<br />
            "artifact_detail": "Recruitment Portal",<br />
            "poc": {<br />
                "user_id": "Rachit806426",<br />
                "company_id": null,<br />
                "first_name": "Rachit",<br />
                "last_name": "Goel",<br />
                "email": null,<br />
                "displayName": "Rachit Goel"<br />
            },<br />
            "used_year": "2022",<br />
            "feature_extended": false,<br />
            "alternate_poc": {<br />
                "user_id": "Bharath790454",<br />
                "company_id": null,<br />
                "first_name": "Bharath",<br />
                "last_name": "Reddy",<br />
                "email": null,<br />
                "displayName": "Bharath Reddy"<br />
            }<br />
        }<br />
    ]<br />
}<br />
<b>**Cached api. Cache age is defined and can configured by changing the 'timeToIdleSeconds' attribute value in src/main/resources/ehcache.xml</b>
</pre>