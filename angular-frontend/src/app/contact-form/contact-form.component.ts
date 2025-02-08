import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-contact-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './contact-form.component.html',
  styleUrl: './contact-form.component.css'
})
export class ContactFormComponent implements OnInit {
  contactForm: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.contactForm = this.fb.group({
      name: [''],
      email: ['']
    });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    let xmldata: string = "<Envelope xmlns='http://schemas.xmlsoap.org/soap/envelope/'>";
    xmldata += "<Body>";
    xmldata += "<ContactRequest xmlns='http://www.example.com/contact'>";
    xmldata += `<name>${this.contactForm.value['name']}</name>`;
    xmldata += `<email>${this.contactForm.value['email']}</email>`;
    xmldata += "</ContactRequest>";
    xmldata += "</Body>";
    xmldata += "</Envelope>";
    const headers = new HttpHeaders({
      'Content-Type': 'text/xml'
    });
    
    this.http.post('http://localhost:4200/ws', xmldata, { headers, responseType: 'text' })
      .subscribe({
        next: (response) => {
          console.log('Response from backend: ', response);
          alert('Response from backend: ' + response);
          window.location.reload()
        },
        error: (e) => {
          console.error('Error: ', e)
        }
    });
  }
}
