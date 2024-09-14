import { Component } from '@angular/core';
import { ScoresServiceService } from '../../services/scores-service.service';
// import de interface de el dato a solicitar import { ? } from '../../../../interfaces/?.model';

@Component({
  selector: 'app-scores',
  standalone: true,
  imports: [],
  templateUrl: './scores.component.html',
  styleUrl: './scores.component.css',
})
export class ScoresComponent {
  scores!: any[]; //reemplazar por dato interface;

  constructor(private scoreService: ScoresServiceService) {
    this.scoreService.getScores().subscribe(
      (response) => {
        console.log('Informacion obtenida', response);
        this.scores = response;
      },
      (error) => console.log(`Error`, error)
    );
  }
}
