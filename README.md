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
responsebody -
{
    "error": false,
    "message": null,
    "data": {
        "clientType": [
            "External",
            "Link Partner",
            "client_base",
            "Internal"
        ],
        "regions": [
            {
                "region_id": "US",
                "region_name": "United States of America"
            },
            {
                "region_id": "CA",
                "region_name": "Canada"
            },
            {
                "region_id": "ES",
                "region_name": "Spain"
            },
            {
                "region_id": "FR",
                "region_name": "France"
            }
        ],
        "projectNames": [
            "Jenny Craig",
            "WorkDay"
        ],
        "practiceNames": [
            "Salesforce B2C",
            "SFCC"
        ],
        "sectorNames": [
            "Retail",
            "HealthCare",
            "FMCG"
        ],
        "categories": [
            {
                "category_name": "ScreenRecording",
                "category_description": null
            },
            {
                "category_name": "Payment",
                "category_description": null
            },
            {
                "category_name": "Shop the look",
                "category_description": null
            }
        ],
        "domainNames": [
            "eCommerce"
        ],
        "projectContactPoint": [
            {
                "user_id": "Suman123653",
                "company_id": null,
                "first_name": "Suman",
                "last_name": null,
                "email": null,
                "displayName": "Suman "
            },
            {
                "user_id": "Kazitanvir124678",
                "company_id": null,
                "first_name": "Kazi",
                "last_name": "tanvir Azad",
                "email": null,
                "displayName": "Kazi tanvir Azad"
            }
        ],
        "subCategories": [
            "CustomFeature",
            "Tracking",
            "SF Integration",
        ]
    }
}
</pre>
<h5><u>Add New Project: </u></h5>
<p><u>Api Details:</u> Rest API to add new project to the database.</p>
URL endpoint - {hostname}/project/addproject<br />
http method - "POST"<br />
<pre>
requestbody -
{
    "project_name": "WorkDay",
    "regions": [
        {
            "region_id": "US"
        },
        {
            "region_id": "CA"
        },
        {
            "region_id": "UK"
        }
    ],
    "sector": {
        "sector_name": "Retail"
    },
    "project_contact_point": {
        "user_id": "Kazitanvir124678"
    },
    "multi_brand": true,
    "brandnames": "Recruiting portal, HR portal",
    "multi_site": true,
    "project_notes": "Portal for recruitment",
    "last_served_year": "2021",
    "clientLead": {
        "client_type": "External"
    },
    "practice": {
        "practice_name": "Salesforce B2C"
    },
    "domain": {
        "domain_name": "eCommerce"
    }
}
<b>**Custom fields value can be achieved from 'forminputdata' api. 'project_name' is a mandatory field.<br /> Empty or null value in 'project_name' will return error in the response for the field. 'project_name' value must be unique.<br /> Throws error in response if 'project_name' already exists.</b>
</pre>
<h5><u>Get Project List: </u></h5>
<p><u>Api Details:</u> Rest API to retrieve all the available Projects from the database.</p>
URL endpoint - {hostname}/project/getprojects<br />
http method - "GET"<br />
produces - "application/json" and "application/xml". Add Accept header for "application/xml"
<pre>
responsebody -
{
    "error": false,
    "message": null,
    "data": [
        {
            "project_name": "WorkDay",
            "id": 0,
            "regions": [
                {
                    "region_id": "US",
                    "region_name": "United States of America"
                },
                {
                    "region_id": "CA",
                    "region_name": "Canada"
                },
                {
                    "region_id": "UK",
                    "region_name": "United Kingdom"
                }
            ],
            "sector": {
                "sector_name": "Retail"
            },
            "project_contact_point": {
                "user_id": "Kazitanvir124678",
                "company_id": null,
                "first_name": "Kazi",
                "last_name": "tanvir Azad",
                "email": null,
                "displayName": "Kazi tanvir Azad"
            },
            "multi_brand": true,
            "brandnames": "Recruiting portal, HR portal",
            "multi_site": true,
            "project_notes": "Portal for recruitment",
            "last_served_year": "2021",
            "clientLead": {
                "client_type": "External"
            },
            "practice": {
                "practice_name": "Salesforce B2C"
            },
            "domain": {
                "domain_name": null
            }
        }
    ]
}
<b>**Cached api. Cache age is defined and can configured by changing the 'timeToIdleSeconds' attribute value in src/main/resources/ehcache.xml</b>
</pre>
<h5><u>Add New Feature: </u></h5>
<p><u>Api Details:</u> Rest API to add new Feature to the database.</p>
URL endpoint - {hostname}/feature/addfeature<br />
http method - "POST"<br />
<pre>
requestbody -
{
    "feature_ref": "recruitment portal",
    "feature_name": "Recruitment Portal",
    "project_name": "WorkDay",
    "category": {
        "category_name": "Customizer"
    },
    "sub_category": {
        "subcategory_name": "CustomFeature"
    },
    "desc": "Recruit candidates through AI",
    "feature_type": "AI implementation",
    "project_contact_point": {
        "user_id": "Rachit806426"
    },
    "artifact_detail": "Recruitment Portal",
    "used_year": "2022",
    "feature_extended": false,
    "alternate_contact_point": {
        "user_id": "Bharath790454"
    }
}
<b>**Custom fields value can be achieved from 'forminputdata' api. 'feature_ref' is a mandatory field.<br /> Empty or null value in 'feature_ref' will return error in the response for the field. 'feature_ref' value must be unique.<br /> Throws error in response if 'feature_ref' already exists.</b>
</pre>
<h5><u>Get FeatureProject data:</u> </h5>
<p><u>Api Details:</u> Rest API to retrieve all the available FeatureProject from the database.</p>
URL endpoint - {hostname}/featureprojects/getfeatureprojects<br />
http method - "GET"<br />
produces - "application/json" and "application/xml". Add Accept header for "application/xml"
<pre>
responsebody -
{
    "error": false,
    "message": null,
    "data": [
        {
            "id": 0,
            "feature": {
                "feature_ref": "recruitment portal",
                "id": 0,
                "project_name": null,
                "feature_name": "Recruitment Portal",
                "category": {
                    "category_name": "Customizer",
                    "category_description": null
                },
                "sub_category": {
                    "subcategory_name": "CustomFeature",
                    "subcategory_description": null
                },
                "desc": "Recruit candidates through AI",
                "feature_type": "AI implementation",
                "project_contact_point": {
                    "user_id": "Rachit806426",
                    "company_id": null,
                    "first_name": "Rachit",
                    "last_name": "Goel",
                    "email": null,
                    "displayName": "Rachit Goel"
                },
                "artifact_detail": "Recruitment Portal",
                "used_year": "2022",
                "feature_extended": false,
                "alternate_contact_point": {
                    "user_id": "Bharath790454",
                    "company_id": null,
                    "first_name": "Bharath",
                    "last_name": "Reddy",
                    "email": null,
                    "displayName": "Bharath Reddy"
                }
            },
            "project": {
                "project_name": "WorkDay",
                "id": 0,
                "regions": [
                    {
                        "region_id": "US",
                        "region_name": "United States of America"
                    },
                    {
                        "region_id": "CA",
                        "region_name": "Canada"
                    }
                ],
                "sector": {
                    "sector_name": "Retail"
                },
                "project_contact_point": {
                    "user_id": "Kazitanvir124678",
                    "company_id": null,
                    "first_name": "Kazi",
                    "last_name": "tanvir Azad",
                    "email": null,
                    "displayName": "Kazi tanvir Azad"
                },
                "multi_brand": true,
                "brandnames": "Recruiting portal, HR portal",
                "multi_site": true,
                "project_notes": "Portal for recruitment",
                "last_served_year": "2021",
                "clientLead": {
                    "client_type": "External"
                },
                "practice": {
                    "practice_name": "Salesforce B2C"
                },
                "domain": {
                    "domain_name": null
                }
            },
            "artifact_detail": "Recruitment Portal",
            "poc": {
                "user_id": "Rachit806426",
                "company_id": null,
                "first_name": "Rachit",
                "last_name": "Goel",
                "email": null,
                "displayName": "Rachit Goel"
            },
            "used_year": "2022",
            "feature_extended": false,
            "alternate_poc": {
                "user_id": "Bharath790454",
                "company_id": null,
                "first_name": "Bharath",
                "last_name": "Reddy",
                "email": null,
                "displayName": "Bharath Reddy"
            }
        }
    ]
}
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
produces - "application/json" and "application/xml". Add Accept header for "application/xml"
<pre>
responsebody -
{
    "error": false,
    "message": null,
    "data": [
         {
            "id": 0,
            "feature": {
                "feature_ref": "recruitment portal",
                "id": 0,
                "project_name": null,
                "feature_name": "Recruitment Portal",
                "category": {
                    "category_name": "Customizer",
                    "category_description": null
                },
                "sub_category": {
                    "subcategory_name": "CustomFeature",
                    "subcategory_description": null
                },
                "desc": "Recruit candidates through AI",
                "feature_type": "AI implementation",
                "project_contact_point": {
                    "user_id": "Rachit806426",
                    "company_id": null,
                    "first_name": "Rachit",
                    "last_name": "Goel",
                    "email": null,
                    "displayName": "Rachit Goel"
                },
                "artifact_detail": "Recruitment Portal",
                "used_year": "2022",
                "feature_extended": false,
                "alternate_contact_point": {
                    "user_id": "Bharath790454",
                    "company_id": null,
                    "first_name": "Bharath",
                    "last_name": "Reddy",
                    "email": null,
                    "displayName": "Bharath Reddy"
                }
            },
            "project": {
                "project_name": "WorkDay",
                "id": 0,
                "regions": [
                    {
                        "region_id": "US",
                        "region_name": "United States of America"
                    },
                    {
                        "region_id": "CA",
                        "region_name": "Canada"
                    },
                    {
                        "region_id": "UK",
                        "region_name": "United Kingdom"
                    }
                ],
                "sector": {
                    "sector_name": "Retail"
                },
                "project_contact_point": {
                    "user_id": "Kazitanvir124678",
                    "company_id": null,
                    "first_name": "Kazi",
                    "last_name": "tanvir Azad",
                    "email": null,
                    "displayName": "Kazi tanvir Azad"
                },
                "multi_brand": true,
                "brandnames": "Recruiting portal, HR portal",
                "multi_site": true,
                "project_notes": "Portal for recruitment",
                "last_served_year": "2021",
                "clientLead": {
                    "client_type": "External"
                },
                "practice": {
                    "practice_name": "Salesforce B2C"
                },
                "domain": {
                    "domain_name": null
                }
            },
            "artifact_detail": "Recruitment Portal",
            "poc": {
                "user_id": "Rachit806426",
                "company_id": null,
                "first_name": "Rachit",
                "last_name": "Goel",
                "email": null,
                "displayName": "Rachit Goel"
            },
            "used_year": "2022",
            "feature_extended": false,
            "alternate_poc": {
                "user_id": "Bharath790454",
                "company_id": null,
                "first_name": "Bharath",
                "last_name": "Reddy",
                "email": null,
                "displayName": "Bharath Reddy"
            }
        }
    ]
}
<b>**Cached api. Cache age is defined and can configured by changing the 'timeToIdleSeconds' attribute value in src/main/resources/ehcache.xml</b>
</pre>