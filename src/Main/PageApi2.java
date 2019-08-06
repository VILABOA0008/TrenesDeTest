
  /button :
    post:
      tags:
      - Button
      summary: Create a Button
      operationId: createButton
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Button'
        required: false
      responses:
        200:
          description: successful operation
          content:
            application/json:
              schema:
                $ref:  '#/components/schemas/ButtonWithId'
    put:
      tags:
      - Button
      summary: Assign Documents
      operationId: addDocument
      parameters:
      - name: idButton
        in: query
        required: true
        schema:
          type: integer
          format: int32
      - name: idDocument
        in: query
        required: true
        schema:
          type: integer
          format: int32
      responses:
        default:
          description: successful operation
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/ButtonWithId'   
    get:
      tags: 
      - Button
      summary: Get active buttons of a Page
      operationId: getActiveButtons
      parameters:
      - name: idPage
        in: query
        required: true
        schema:
          type: integer
          format: int32
      - name: active
        in: query
        required: true
        schema:
          type: boolean
      responses:
        200:
          description: get active or no active buttons of a Page 
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Button'
  /button/Document:        
    get:
      tags: 
      - Button
      summary: Get Documents of a Button
      operationId: getDocumentByButton
      parameters:
      - name: idButton
        in: query
        required: true
        schema:
          type: integer
          format: int32
      responses:
        200:
          description: get the Documents of a Button
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/DocumentWithId'
  /button/{idButton}:
    get:
      tags:
      - Button
      summary: get a Button by his Id
      operationId: getButtonByID
      parameters:
      - name: idButton
        in: path
        required: true
        schema:
          type: integer
          format: int32
      responses:
        default:
          description: successful operation
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Button'
    put:
      tags:
      - Button
      summary: Modify a Button
      operationId: ModifyButton
      parameters:
      - name: idButton
        in: path
        required: true
        schema:
          type: integer
          format: int32
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref:  '#/components/schemas/ButtonWithId'
        
      responses:
        200:
          description: successful operation
          content:
            application/json:
              schema:
                $ref:  '#/components/schemas/ButtonWithId'
    delete:
      tags:
      - Button
      summary: Delete a Button
      operationId: deleteButtonByID
      parameters:
      - name: idButton
        in: path
        required: true
        schema:
          type: integer
          format: int32
      responses:
        '200':
          description: successful operation
  /page :
    post:
      tags:
      - Page
      summary: Create a Page
      operationId: createPage
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Page'
        required: false
      responses:
        200:
          description: successful operation
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/PageWithId'
    get:
      tags: 
      - Page
      summary: Get All Pages
      operationId: getAllPages
      responses:
        200:
          description: all available pages retrieved
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/PageWithId'
  /page/{idPage}:
    get:
      tags:
      - Page
      summary: Get a Page by his Id
      operationId: getPageById
      parameters:
      - name: idPage
        in: path
        required: true
        schema:
          type: integer
          format: int32
      responses:
        default:
          description: successful operation
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Page'
    put:
      tags:
      - Page
      summary: Modify a Page
      parameters:
      - name: idPage
        in: path
        required: true
        schema:
          type: integer
          format: int32
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/PageWithId'
        required: false
      responses:
        200:
          description: successful operation
          content:
            application/json:
              schema:
                $ref:  '#/components/schemas/PageWithId'
  /page/buttons/{idPage}:
    get:
      tags:
      - Page
      summary: Get buttons of a Page
      operationId: getPageButtons
      parameters:
      - name: idPage
        in: path
        required: true
        schema:
          type: integer
          format: int32
      responses:
        default:
          description: successful operation
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/ButtonWithId'
                
  /document/{idDocument}:
    get:
      tags:
      - Document
      summary: Get a Document by his Id
      operationId: getDocumentById
      description: get a document by id
      parameters:
      - name: idDocument
        in: path
        required: true
        schema:
          type: integer
          format: int32
      responses:
        default:
          description: successful operation
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Document'
    put:
      tags:
      - Document
      summary: Modify a Document
      operationId: ModifyDocument
      parameters:
      - name: idDocument
        in: path
        required: true
        schema:
          type: integer
          format: int32
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/DocumentWithId'
        required: false
      responses:
        200:
          description: successful operation
          content:
            application/json:
              schema:
                $ref:  '#/components/schemas/DocumentWithId'
  /document :        
    get:
      tags: 
      - Document
      summary: Get all Documents
      operationId: getAllDocuments
      responses:
        200:
          description: all available documents retrieved
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/DocumentWithId'
                  
    post:
      tags:
      - Document
      summary: Create a Document
      operationId: createDocument
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Document'
      responses:
        200:
          description: successful operation
          content:
            application/json:
              schema:
                $ref:  '#/components/schemas/DocumentWithId'
    put:
      tags:
      - Document
      summary: Assign Button
      operationId: addButton
      parameters:
      - name: idDocument
        in: query
        required: true
        schema:
          type: integer
          format: int32
      - name: idButton
        in: query
        required: true
        schema:
          type: integer
          format: int32
      responses:
        default:
          description: successful operation
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/DocumentWithId'  
 
  /document/repo:  
    get:
      tags: 
      - Document
      summary: Get Picuture of Documents
      operationId: test
      parameters:
      - name: url
        in: query
        required: true
        schema:
          type: string
      responses:
        '200':
          description: A picture of the file in the url
          
    post:
      tags: 
      - Document
      summary: Upload a file
      operationId: UploadFile
      requestBody:
       content:
         multipart/form-data:
           schema:
             type: object
             properties:
               content:
                 type: string
                 format: binary
             required:
               - uploadPDF
      parameters:
      - name: name
        in: query
        required: true
        schema:
          type: string

      responses:
        '200':
          description: The file was upload correctly
          
    delete:
      tags: 
      - Document
      summary: Delete a node
      operationId: DeleteNode
      parameters:
      - name: node
        in: query
        required: true
        schema:
          type: string
      responses:
        '200':
          description: The file was deleted correctly
                
    put:
      tags:
        - Document
      operationId: Refresh a copy
      requestBody:
        content:
          multipart/form-data:
            schema:
              type: object
              properties:
                image:
                  type: string
                link:
                  type: string
      responses:
        default:
          description: successful operation
          
  /document/reset:  
    put:
      tags:
        - Document
      operationId: resetPicture
      parameters:
      - name: link
        in: query
        required: true
        schema:
          type: string
      responses:
        default:
          description: successful operation
  /line :        
    get:
      tags: 
      - Line
      summary: Get all Lines
      operationId: getAllLines
      responses:
        200:
          description: all available lines retrieved
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Line'
                  
  /line/{idLine}:
    get:
      tags:
      - Line
      summary: Get a Line by his Id
      operationId: getLineById
      parameters:
      - name: idLine
        in: path
        required: true
        schema:
          type: integer
          format: int32
      responses:
        200:
          description: all available pages retrieved
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/PageWithId'
components:
  schemas:
    Button:
      type: object
      required: 
      - name
      - idPage
      - x
      - y
      - w
      - h
      - active
      - order
      - shortName
      properties:
        idPage:
          type: integer
          format: int32
        name:
          type: string
          maxLength: 255
        x:
          type: integer
          format: int32
        y:
          type: integer
          format: int32
        w:
          type: integer
          format: int32
        h:
          type: integer
          format: int32
        active:
          type: boolean
        order:
          type: integer
          format: int32
          description: order
        shortName:
          type: string
          description: shortName
    ButtonWithId:
      allOf:
      - $ref: '#/components/schemas/Button'
      - type: object
        properties:
          idButton:
            type: integer
            format: int32
        required: 
        - idButton
    PageButton:
      allOf:
      - $ref: '#/components/schemas/Page'
      - type: object
        properties:
          Buttons:
            type: array
            items:
              $ref: '#/components/schemas/Button'
        required:
        - Buttons
    Page:
      type: object
      required: 
      - name
      - order
      - active
      - rows
      properties:
        name:
          type: string
        order:
          type: integer
          format: int32
        active:
          type: boolean
        idLine:
          type: integer
          format: int32
        rows:
          type: integer
          format: int32

    PageWithId:
      allOf:
      - $ref: '#/components/schemas/Page'
      - type: object
        properties:
          idPage:
            type: integer
            format: int32
        required: 
        - idPage
    Line:
      type: object
      required: 
      - idLine
      - Name
      - Active
      properties:
        idLine:
          type: integer
          format: int32  
        Name:
          type: string
        Active:
          type: integer
          format: int32  


    Document:
      type: object
      required: 
      - name
      - link
      - idDocType
      properties:
        name:
          type: string
        link:
          type: string
        idDocType:
          type: integer
          format: int32
        content:
          type: string
          format: binary
    DocumentWithId:
      allOf:
      - $ref: '#/components/schemas/Document'
      - type: object
        properties:
          idDocument:
            type: integer
            format: int32
        required: 
        - idDocument